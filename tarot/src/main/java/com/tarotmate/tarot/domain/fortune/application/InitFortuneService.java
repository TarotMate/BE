package com.tarotmate.tarot.domain.fortune.application;

import com.tarotmate.tarot.domain.fortune.application.model.InitialPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class InitFortuneService {

    public InitialPageResponse getTarotPage() {
        return InitialPageResponse.ofEntity();
    }


/*
    public TarotPageResponse getTarotPage(String fortuneType, String theme){
        final TarotPageResponse tarotPage = TarotPageResponse.getDefaultTarotPage();

        if (Objects.equals("today-tarot", fortuneType)) {
            switch (theme) {
                case "star-story":
                    break;
                case "today-preview":
                    tarotPage.changeTheme("오늘의 에너지", Arrays.asList("오늘의 에너지", "기회와 도전", "중요한 선택"));
                    break;
                case "daily-insight":
                    tarotPage.changeTheme("일상의 작은 기쁨", Arrays.asList("일상의 작은 기쁨", "주의깊게 살펴볼 것", "숨겨진 기회"));
                    break;
                case "end-of-day":
                    tarotPage.changeTheme("오늘의 교훈", Arrays.asList("오늘의 교훈", "감사할 점", "내일을 위한 준비"));
                    break;
                default:
                    throw new Exception400(ErrorCode.ER06);
            }
        }
        else if (Objects.equals("love-tarot", fortuneType)) {
            switch (theme) {
                case "star-story":
                    tarotPage.changeFortuneType(InitPage.LOVE_TAROT, "심장의 메시지", Arrays.asList("심장의 메시지", "새로운 인연", "애정의 조화와 갈등"));
                    break;
                case "new-love":
                    tarotPage.changeFortuneType(InitPage.LOVE_TAROT, "첫 만남의 운", Arrays.asList("첫 만남의 운", "새로운 감정의 발견", "인연의 가능성"));
                    break;
                case "relationship":
                    tarotPage.changeFortuneType(InitPage.LOVE_TAROT, "감정의 깊이", Arrays.asList("감정의 깊이", "서로의 이해", "관계의 진전"));
                    break;
                case "recovery":
                    tarotPage.changeFortuneType(InitPage.LOVE_TAROT, "내면의 치유", Arrays.asList("내면의 치유", "새로운 시작", "자기 사랑"));
                    break;
                default:
                    throw new Exception400(ErrorCode.ER06);
            }
        }
        else if (Objects.equals("this-month-tarot", fortuneType)) {
            switch (theme) {
                case "star-story":
                    tarotPage.changeFortuneType(InitPage.TAROT_OF_THE_MONTH, "심장의 메시지", Arrays.asList("심장의 메시지", "새로운 인연", "애정의 조화와 갈등"));
                    break;
                case "new-love":
                    tarotPage.changeFortuneType(InitPage.TAROT_OF_THE_MONTH, "첫 만남의 운", Arrays.asList("첫 만남의 운", "새로운 감정의 발견", "인연의 가능성"));
                    break;
                case "relationship":
                    tarotPage.changeFortuneType(InitPage.TAROT_OF_THE_MONTH, "감정의 깊이", Arrays.asList("감정의 깊이", "서로의 이해", "관계의 진전"));
                    break;
                case "recovery":
                    tarotPage.changeFortuneType(InitPage.TAROT_OF_THE_MONTH, "내면의 치유", Arrays.asList("내면의 치유", "새로운 시작", "자기 사랑"));
                    break;
                default:
                    throw new Exception400(ErrorCode.ER06);
            }
        }
        else throw new Exception400(ErrorCode.ER07);

        return tarotPage;
    }
 */
}
