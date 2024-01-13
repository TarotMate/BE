package com.tarotmate.tarot.domain.fortune.application.model;

import com.tarotmate.tarot.global.utils.InitPage;
import com.tarotmate.tarot.global.utils.TarotCard;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@ToString
@Getter
@Builder
public class InitialPageResponse {
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
        private String subTitle;
        private List<String> cardDescriptions;
    }
}