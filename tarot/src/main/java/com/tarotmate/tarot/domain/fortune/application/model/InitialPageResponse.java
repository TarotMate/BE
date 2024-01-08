package com.tarotmate.tarot.domain.fortune.application.model;

import com.tarotmate.tarot.global.utils.InitPage;
import com.tarotmate.tarot.global.utils.TarotCard;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

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
        private List<String> cardDescriptions;
    }


    public static InitialPageResponse ofEntity() {
        return InitialPageResponse.builder()
                .tarotCards(createTarotCardDTOs())
                .fortunes(Arrays.asList(
                        InitialPageResponse.FortuneDTO.builder()
                                .label(InitPage.TODAY_TAROT)
                                .value("오늘의 운세")
                                .descriptions(Arrays.asList(
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("오늘의 감정 흐름", "기회와 장애물", "일과 삶의 균형"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("오늘의 에너지", "기회와 도전", "중요한 선택"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("일상의 작은 기쁨", "주의 깊게 살펴볼 것", "숨겨진 기회"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("오늘의 교훈", "감사할 점", "내일을 위한 준비"))
                                                .build()
                                ))
                                .build(),
                        InitialPageResponse.FortuneDTO.builder()
                                .label(InitPage.LOVE_TAROT)
                                .value("연애운")
                                .descriptions(Arrays.asList(
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("심장의 메시지", "새로운 인연", "애정의 조화와 갈등"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("첫 만남의 운", "새로운 감정의 발견", "인연의 가능성"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("감정의 깊이", "서로의 이해", "관계의 진전"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("내면의 치유", "새로운 시작", "자기 사랑"))
                                                .build()
                                ))
                                .build(),
                        InitialPageResponse.FortuneDTO.builder()
                                .label(InitPage.TAROT_OF_THE_MONTH)
                                .value("이번달 운세")
                                .descriptions(Arrays.asList(
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("이달의 지침", "운명의 선물", "경계할 점", "예상치 못한 사건", "지혜로운 대처"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("이달의 주요 사건", "행운의 순간", "주의해야 할 일"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("새로운 만남", "갈등과 화해", "관계의 성장"))
                                                .build(),
                                        InitialPageResponse.FortuneDescriptionDTO.builder()
                                                .cardDescriptions(Arrays.asList("자기 인식", "능력 개발", "정서적 균형"))
                                                .build()
                                ))
                                .build()
                ))
                .cardBackImage(InitPage.BACK_CARD_IMAGE_URL)
                .build();

    }
    public static List<TarotCardDTO> createTarotCardDTOs() {
        return Arrays.asList(
                TarotCardDTO.builder().number(TarotCard.THE_FOOL.getNumber()).name(TarotCard.THE_FOOL.getName()).image(TarotCard.THE_FOOL.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_MAGICIAN.getNumber()).name(TarotCard.THE_MAGICIAN.getName()).image(TarotCard.THE_MAGICIAN.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_HIGH_PRIESTESS.getNumber()).name(TarotCard.THE_HIGH_PRIESTESS.getName()).image(TarotCard.THE_HIGH_PRIESTESS.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_EMPRESS.getNumber()).name(TarotCard.THE_EMPRESS.getName()).image(TarotCard.THE_EMPRESS.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_EMPEROR.getNumber()).name(TarotCard.THE_EMPEROR.getName()).image(TarotCard.THE_EMPEROR.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_HIEROPHANT.getNumber()).name(TarotCard.THE_HIEROPHANT.getName()).image(TarotCard.THE_HIEROPHANT.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_LOVERS.getNumber()).name(TarotCard.THE_LOVERS.getName()).image(TarotCard.THE_LOVERS.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_CHARIOT.getNumber()).name(TarotCard.THE_CHARIOT.getName()).image(TarotCard.THE_CHARIOT.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.STRENGTH.getNumber()).name(TarotCard.STRENGTH.getName()).image(TarotCard.STRENGTH.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_HERMIT.getNumber()).name(TarotCard.THE_HERMIT.getName()).image(TarotCard.THE_HERMIT.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.WHEEL_OF_FORTUNE.getNumber()).name(TarotCard.WHEEL_OF_FORTUNE.getName()).image(TarotCard.WHEEL_OF_FORTUNE.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.JUSTICE.getNumber()).name(TarotCard.JUSTICE.getName()).image(TarotCard.JUSTICE.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_HANGED_MAN.getNumber()).name(TarotCard.THE_HANGED_MAN.getName()).image(TarotCard.THE_HANGED_MAN.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.DEATH.getNumber()).name(TarotCard.DEATH.getName()).image(TarotCard.DEATH.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.TEMPERANCE.getNumber()).name(TarotCard.TEMPERANCE.getName()).image(TarotCard.TEMPERANCE.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_DEVIL.getNumber()).name(TarotCard.THE_DEVIL.getName()).image(TarotCard.THE_DEVIL.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_TOWER.getNumber()).name(TarotCard.THE_TOWER.getName()).image(TarotCard.THE_TOWER.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_STAR.getNumber()).name(TarotCard.THE_STAR.getName()).image(TarotCard.THE_STAR.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_MOON.getNumber()).name(TarotCard.THE_MOON.getName()).image(TarotCard.THE_MOON.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_SUN.getNumber()).name(TarotCard.THE_SUN.getName()).image(TarotCard.THE_SUN.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.JUDGEMENT.getNumber()).name(TarotCard.JUDGEMENT.getName()).image(TarotCard.JUDGEMENT.getImageUrl()).build(),
                TarotCardDTO.builder().number(TarotCard.THE_WORLD.getNumber()).name(TarotCard.THE_WORLD.getName()).image(TarotCard.THE_WORLD.getImageUrl()).build()
        );
    }
}


/*
    private List<String> fortuneTypes;
    private String currentSelectedType;
    private String backCardImage;
    private String notice;
    private String cardToDrawNext;
    private String drawPhrases;
    private String preview;
    private List<String> whatToKnow;

    public static TarotPageResponse getDefaultTarotPage() {
        return TarotPageResponse.builder()
                .fortuneTypes(Arrays.asList(InitPage.TODAY_TAROT, InitPage.LOVE_TAROT, InitPage.TAROT_OF_THE_MONTH))
                .currentSelectedType(InitPage.TODAY_TAROT)
                .backCardImage("URL")
                .notice("카드를 눌러주세요")
                .cardToDrawNext("오늘의 감정 흐름")
                .drawPhrases("에 대한 카드를 뽑겠습니다.")
                .preview("선택된 카드 미리보기")
                .whatToKnow(Arrays.asList("오늘의 감정 흐름", "기회와 장애물", "일과 삶의 균형"))
                .build();
    }

    public void updateBackCardImage(final String backCardImage) {
        this.backCardImage = backCardImage;
    }

    public void changeFortuneType(final String currentSelectedType, final String cardToDrawNext, final List<String> whatToKnow) {
        this.currentSelectedType = currentSelectedType;
        this.cardToDrawNext = cardToDrawNext;
        this.whatToKnow = whatToKnow;
    }

    public void changeTheme(final String cardToDrawNext, final List<String> whatToKnow) {
        this.cardToDrawNext = cardToDrawNext;
        this.whatToKnow = whatToKnow;
    }

 */
