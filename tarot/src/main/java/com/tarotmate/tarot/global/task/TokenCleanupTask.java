package com.tarotmate.tarot.global.task;

import com.tarotmate.tarot.domain.user.domain.User;
import com.tarotmate.tarot.global.certification.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TokenCleanupTask {
    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Transactional @Scheduled(cron = "0 0 0 * * ?")
    public void cleanupExpiredToken() {
        log.info("Start cleaning up expired tokens!");
        tokenRepository.deleteAllExpiredTokens(LocalDateTime.now());
    }
}
