package com.tarotmate.tarot.global.utils;

import lombok.Data;

import java.util.List;

@Data
public class OpenAIResponse {
    private String id;
    private String object;
    private Long created;
    private String model;
    private List<Choice> choices;

    @Data
    public static class Choice {
        private int index;
        private Message message;
    }

    @Data
    public static class Message {
        private String role;
        private String content; // JSON 문자열
    }
}

