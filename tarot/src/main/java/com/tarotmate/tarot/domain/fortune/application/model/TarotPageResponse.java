package com.tarotmate.tarot.domain.fortune.application.model;

import com.tarotmate.tarot.global.utils.InitPage;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
public class TarotPageResponse {

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
}
