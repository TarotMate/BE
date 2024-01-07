package com.tarotmate.tarot.domain.fortune.application.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class FortuneResponseDTO {
    private final List<TarotCardDTO> tarotCards;
    private final List<FortuneDTO> fortunes;
    private final String cardBackImage;


    @Getter
    @Builder
    public static class TarotCardDTO {
        private int number;
        private String name;
        private String image;
    }

    @Getter
    @Builder
    public static class FortuneDTO {
        private String label;
        private String value;
        private List<FortuneDescriptionDTO> descriptions;
    }

    @Getter
    @Builder
    public static class FortuneDescriptionDTO {
        private String title;
        private String subtitle;
        private List<String> cardDescriptions;
    }
}
