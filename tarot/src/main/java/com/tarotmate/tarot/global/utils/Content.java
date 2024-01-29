package com.tarotmate.tarot.global.utils;

import lombok.Data;

import java.util.List;

@Data
public class Content {
    private List<CardInfo> fortune;
    private String additionalComment;

    @Data
    public static class CardInfo {
        private String cardName;
        private int starRating;
        private String shortComment;
        private String detail;
        private List<String> hashTags;
    }
}
