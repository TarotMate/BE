package com.tarotmate.tarot.domain.fortune.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class FortuneResponse {
    private List<Card> fortune;

    @Data
    public static class Card {

        @JsonProperty("cardDescription")
        private String cardDescription;

        @JsonProperty("cardName")
        private String cardName;

        @JsonProperty("starRating")
        private int starPoint;

        @JsonProperty("hashTags")
        private List<String> hashTags;

        @JsonProperty("shortComment")
        private String shortComment;

        @JsonProperty("detail")
        private String detail;

        @JsonProperty("cardImage")
        private String cardImage;
    }
}
