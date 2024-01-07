package com.tarotmate.tarot.domain.fortune.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class OpenAIResponseDTO {
    private final List<Choice> choices;

    public OpenAIResponseDTO(@JsonProperty("choices") List<Choice> choices) {
        this.choices = choices;
    }

    @Getter
    public static class Choice {
        private final Message message;

        public Choice(@JsonProperty("message") Message message) {
            this.message = message;
        }
    }

    @Getter
    public static class Message {
        private final String content;

        public Message(@JsonProperty("content") String content) {
            this.content = content;
        }
    }
}
