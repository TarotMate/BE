package com.tarotmate.tarot.domain.fortune.application;

import com.tarotmate.tarot.domain.fortune.application.model.InitialPageResponse;
import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception500;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class InitFortuneService {

    private final InitialPageLoader initialPageLoader;

    public InitialPageResponse getTarotPage() {
        final InitialPageResponse initialPageResponse;
        try {
            initialPageResponse = initialPageLoader.loadInitialData();
        } catch (final IOException e) {
            throw new Exception500(ErrorCode.ER10.getCode());
        }
        return initialPageResponse;
    }
}
