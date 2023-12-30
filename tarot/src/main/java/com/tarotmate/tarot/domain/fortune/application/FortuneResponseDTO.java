package com.tarotmate.tarot.domain.fortune.application;

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
    static class TarotCardDTO {
        private int number;
        private String name;
        private String image;
    }

    @Getter
    @Builder
    static class FortuneDTO {
        private String label;
        private String value;
        private List<FortuneDescriptionDTO> descriptions;
    }

    @Getter
    @Builder
    static class FortuneDescriptionDTO {
        private String title;
        private String subtitle;
        private List<String> cardDescriptions;
    }
}
