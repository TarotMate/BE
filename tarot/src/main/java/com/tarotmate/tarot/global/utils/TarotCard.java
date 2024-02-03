package com.tarotmate.tarot.global.utils;


import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception404;
import lombok.Getter;

@Getter
public enum TarotCard {
    // 메이저 아르카나
    THE_FOOL(0, "광대", "../images/major_arcana_fool.png"),
    THE_MAGICIAN(1, "마법사", "../images/major_arcana_magician.png"),
    THE_HIGH_PRIESTESS(2, "여사제", "../images/major_arcana_priestess.png"),
    THE_EMPRESS(3, "여황제", "../images/major_arcana_empress.png"),
    THE_EMPEROR(4, "황제", "../images/major_arcana_emperor.png"),
    THE_HIEROPHANT(5, "교황", "../images/major_arcana_hierophant.png"),
    THE_LOVERS(6, "연인", "../images/major_arcana_lovers.png"),
    THE_CHARIOT(7, "전차", "../images/major_arcana_chariot.png"),
    STRENGTH(8, "힘", "../images/major_arcana_strength.png"),
    THE_HERMIT(9, "은둔자", "../images/major_arcana_hermit.png"),
    WHEEL_OF_FORTUNE(10, "운명의 수레바퀴", "../images/major_arcana_fortune.png"),
    JUSTICE(11, "정의", "../images/major_arcana_justice.png"),
    THE_HANGED_MAN(12, "매달린 사람", "../images/major_arcana_hanged.png"),
    DEATH(13, "죽음", "../images/major_arcana_death.png"),
    TEMPERANCE(14, "절제", "../images/major_arcana_temperance.png"),
    THE_DEVIL(15, "악마", "../images/major_arcana_devil.png"),
    THE_TOWER(16, "탑", "../images/major_arcana_tower.png"),
    THE_STAR(17, "별", "../images/major_arcana_star.png"),
    THE_MOON(18, "달", "../images/major_arcana_moon.png"),
    THE_SUN(19, "태양", "../images/major_arcana_sun.png"),
    JUDGEMENT(20, "심판", "../images/major_arcana_judgement.png"),
    THE_WORLD(21, "세계", "../images/major_arcana_world.png");

    // TODO: 마이너 아르카나 추가시 고도화 예정


    private final Integer number;
    private final String name;
    private final String imageUrl;

    TarotCard(final Integer number, final String name, final String imageUrl) {
        this.number = number;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static TarotCard fromNumber(final int number) {
        for (final TarotCard card : values()) {
            if (card.number.equals(number)) {
                return card;
            }
        }
        throw new Exception404(ErrorCode.ER02.getCode());
    }
}
