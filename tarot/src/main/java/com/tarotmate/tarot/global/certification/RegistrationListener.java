package com.tarotmate.tarot.global.certification;

import com.tarotmate.tarot.domain.user.application.IUserService;
import com.tarotmate.tarot.domain.user.domain.User;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    private final IUserService service;
    private final JavaMailSender mailSender;
    private final MessageSource messages;

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        confirmRegistration(event);
    }
    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = "https://api.tarotmate.kr" + event.getAppUrl() + "/regitrationConfirm?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, event.getLocale());

        final MimeMessage email = mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(email, "utf-8");
        try {
            helper.setFrom("tarotmatekr@naver.com");
            helper.setTo(recipientAddress);
            helper.setSubject(subject);
            helper.setText("<html><body>"
                    + message
                    + "<br><a href=\""
                    + confirmationUrl
                    + "\">여기를 클릭하여 등록을 완료하세요.</a></body></html>", true);
        } catch (final MessagingException e) {
            log.error(e.getMessage());
            throw new Exception500(ErrorCode.ER12.getCode());
        }

//        final SimpleMailMessage email = new SimpleMailMessage();
//        email.setFrom();
//        email.setTo(recipientAddress);
//        email.setSubject(subject);
//        email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
