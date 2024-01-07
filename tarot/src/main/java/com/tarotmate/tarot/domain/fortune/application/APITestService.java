package com.tarotmate.tarot.domain.fortune.application;

import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class APITestService {

    public FortuneResponseDTO getDefaultResponse(){
        return FortuneResponseDTO.builder()
                .tarotCards(Arrays.asList(
                        FortuneResponseDTO.TarotCardDTO.builder().number(0).name("광대").image("../images/major_arcana_fool.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(1).name("마법사").image("../images/major_arcana_magician.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(2).name("여사제").image("../images/major_arcana_priestess.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(3).name("여황제").image("../images/major_arcana_empress.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(4).name("황제").image("../images/major_arcana_emperor.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(5).name("교황").image("../images/major_arcana_hierophant.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(6).name("연인들").image("../images/major_arcana_lovers.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(7).name("전차").image("../images/major_arcana_chariot.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(8).name("힘").image("../images/major_arcana_strength.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(9).name("은둔자").image("../images/major_arcana_hermit.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(10).name("운명의 수레바퀴").image("../images/major_arcana_fortune.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(11).name("정의").image("../images/major_arcana_justice.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(12).name("매달린 사람").image("../images/major_arcana_hanged.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(13).name("죽음").image("../images/major_arcana_death.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(14).name("절제").image("../images/major_arcana_temperance.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(15).name("악마").image("../images/major_arcana_devil.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(16).name("탑").image("../images/major_arcana_tower.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(17).name("별").image("../images/major_arcana_star.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(18).name("달").image("../images/major_arcana_moon.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(19).name("태양").image("../images/major_arcana_sun.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(20).name("심판").image("../images/major_arcana_judgement.png").build(),
                        FortuneResponseDTO.TarotCardDTO.builder().number(21).name("세계").image("../images/major_arcana_world.png").build()
                                ))
                .fortunes(Arrays.asList(
                        FortuneResponseDTO.FortuneDTO.builder()
                                .label("오늘의타로")
                                .value("오늘의 운세")
                                .descriptions(Arrays.asList(
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("오늘, 별들이 당신에게 전하는 이야기")
                                                .subtitle("별빛 아래 오늘의 운명을 탐색해 보세요.")
                                                .cardDescriptions(Arrays.asList("오늘의 감정 흐름", "기회와 장애물", "일과 삶의 균형"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("하루의 전망")
                                                .subtitle("새로운 날의 기대감 속에서 당신의 운명을 탐색해보세요.")
                                                .cardDescriptions(Arrays.asList("오늘의 에너지", "기회와 도전", "중요한 선택"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("일상의 통찰")
                                                .subtitle("평범한 순간 속에서 발견하는 특별한 조언.")
                                                .cardDescriptions(Arrays.asList("일상의 작은 기쁨", "주의 깊게 살펴볼 것", "숨겨진 기회"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("하루의 마무리")
                                                .subtitle("하루의 끝에서 발견하는 평화와 성찰.")
                                                .cardDescriptions(Arrays.asList("오늘의 교훈", "감사할 점", "내일을 위한 준비"))
                                                .build()
                                ))
                                .build(),
                        FortuneResponseDTO.FortuneDTO.builder()
                                .label("연애타로")
                                .value("연애운")
                                .descriptions(Arrays.asList(
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("사랑의 길을 밝혀주는 별빛")
                                                .subtitle("당신의 사랑을 탐색하세요.")
                                                .cardDescriptions(Arrays.asList("심장의 메시지", "새로운 인연", "애정의 조화와 갈등"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("새로운 사랑")
                                                .subtitle("새로운 사랑을 찾고 계신가요? 카드가 당신의 운명을 알려줄 거예요")
                                                .cardDescriptions(Arrays.asList("첫 만남의 운", "새로운 감정의 발견", "인연의 가능성"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("관계의 발전")
                                                .subtitle("현재 관계를 더 깊게 발전시키고 싶으신가요? 어떤 변화가 필요한지 타로가 알려드립니다")
                                                .cardDescriptions(Arrays.asList("감정의 깊이", "서로의 이해", "관계의 진전"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("이별 후의 회복")
                                                .subtitle("이별의 아픔을 겪고 계시나요? 이 카드들이 당신에게 위로와 희망을 줄 것입니다")
                                                .cardDescriptions(Arrays.asList("내면의 치유", "새로운 시작", "자기 사랑"))
                                                .build()
                                ))
                                .build(),
                        FortuneResponseDTO.FortuneDTO.builder()
                                .label("이달의타로")
                                .value("이번달 운세")
                                .descriptions(Arrays.asList(
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("이달의 여정")
                                                .subtitle("우주의 리듬에 맞춰 이달을 탐험해보세요.")
                                                .cardDescriptions(Arrays.asList("이달의 지침", "운명의 선물", "경계할 점", "예상치 못한 사건", "지혜로운 대처"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("이달의 전망")
                                                .subtitle("한 달 동안의 여정을 예측해보세요.")
                                                .cardDescriptions(Arrays.asList("이달의 주요 사건", "행운의 순간", "주의해야 할 일"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("월간 관계 동향")
                                                .subtitle("가까운 이들과의 관계에 어떤 변화가 있을까요?")
                                                .cardDescriptions(Arrays.asList("새로운 만남", "갈등과 화해", "관계의 성장"))
                                                .build(),
                                        FortuneResponseDTO.FortuneDescriptionDTO.builder()
                                                .title("개인적 성장과 발전")
                                                .subtitle("이달 당신이 이룰 수 있는 성장에 대해 탐색해보세요.")
                                                .cardDescriptions(Arrays.asList("자기 인식", "능력 개발", "정서적 균형"))
                                                .build()
                                ))
                                .build()
                ))
                .cardBackImage("../images/bcard.png")
                .build();
    }
}
