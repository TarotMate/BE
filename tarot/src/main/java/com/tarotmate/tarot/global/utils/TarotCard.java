package com.tarotmate.tarot.global.utils;


import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import lombok.Getter;

public enum TarotCard {
    // 메이저 아르카나
    THE_FOOL("00", "(The Fool)"),
    THE_MAGICIAN("01", "(The Magician)"),
    THE_HIGH_PRIESTESS("02", "(The High Priestess)"),
    THE_EMPRESS("03", "The Empress"),
    THE_EMPEROR("04", "The Emperor"),
    THE_HIEROPHANT("05", "The Hierophant"),
    THE_LOVERS("06", "The Lovers"),
    THE_CHARIOT("07", "The Chariot"),
    STRENGTH("08", "Strength"),
    THE_HERMIT("09", "The Hermit"),
    WHEEL_OF_FORTUNE("10", "Wheel of Fortune"),
    JUSTICE("11", "Justice"),
    THE_HANGED_MAN("12", "The Hanged Man"),
    DEATH("13", "Death"),
    TEMPERANCE("14", "Temperance"),
    THE_DEVIL("15", "The Devil"),
    THE_TOWER("16", "The Tower"),
    THE_STAR("17", "The Star"),
    THE_MOON("18", "The Moon"),
    THE_SUN("19", "The Sun"),
    JUDGEMENT("20", "Judgement"),
    THE_WORLD("21", "The World");

    // TODO: 마이너 아르카나 추가시 고도화 예정


    private final String number;
    @Getter
    private final String name;

    TarotCard(final String number, final String name) {
        this.number = number;
        this.name = name;
    }

    private String getNumber() {
        return number;
    }

    public static TarotCard fromNumber(final String number) {
        for (final TarotCard card : values()) {
            if (card.number.equals(number)) {
                return card;
            }
        }
        throw new Exception404(ErrorCode.ER02);
    }
}
