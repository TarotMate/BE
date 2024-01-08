package com.tarotmate.tarot.domain.fortune.application.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class TarotRequest {
    private final String fortuneType;
    private final String theme;
    private final List<Integer> selectedCardNumbers;
    private final List<String> cardDescriptions;
}
