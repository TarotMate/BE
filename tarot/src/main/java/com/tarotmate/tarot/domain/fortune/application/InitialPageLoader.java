package com.tarotmate.tarot.domain.fortune.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarotmate.tarot.domain.fortune.application.model.InitialPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Component
public class InitialPageLoader {
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    public InitialPageResponse loadInitialData() throws IOException {
        final var fileResource = resourceLoader.getResource("classpath:static/initData.json");
        final var fileContent = new String(Files.readAllBytes(Paths.get(fileResource.getURI())));

        return objectMapper.readValue(fileContent, InitialPageResponse.class);
    }
}
