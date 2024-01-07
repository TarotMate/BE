package com.tarotmate.tarot.global.utils.prompt;

import com.tarotmate.tarot.global.utils.TarotCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public enum FortunePrompt {
    STAR_STORY;

    public String getBasicSystemPrompt(){
        return "You are very good at interpreting tarot cards. Please feel free to interpret the user's situation regarding the tarot cards. Users will provide information about their situation.";
    }

    public String getAnswerFormatSetting() {
        return "Your customers are Korean, so please answer in Korean. Please speak informally.";
    }

    public String getReturnTypeSetting() {

        // JSON 객체 생성
        final JSONObject fortuneObj = new JSONObject();
        final JSONArray fortuneArray = new JSONArray();

        // 카드 정보를 담은 JSON 객체 생성
        final JSONObject cardInfo = new JSONObject();
        cardInfo.put("cardName", "운명의 수레바퀴 (Wheel of Fortune)");
        cardInfo.put("starPoint", 4);
        cardInfo.put("shortComment", "오늘은 연인과의 관계가 깊이 있게 발전할 수 있습니다.");
        cardInfo.put("detail", "상세적인 카드 해석");

        // 해시태그 배열 생성
        final JSONArray hashTags = new JSONArray();
        hashTags.add("#변화의 필요성");
        hashTags.add("#전환점");
        hashTags.add("#행운");
        hashTags.add("#필연성");
        cardInfo.put("hashTag", hashTags);

        // JSON 배열에 카드 정보 추가
        fortuneArray.add(cardInfo);

        // 최종 JSON 객체에 배열 추가
        fortuneObj.put("fortune", fortuneArray);

        // JSON 객체를 문자열로 변환
        return "Please return the response value in json format. example) " + fortuneObj.toString();
    }

    public String getAdditionalExplain() {
        return "Below is an explanation of the json key value as an example. fortune is an array of interpretations of the cards chosen by the user. If the user draws 3 cards, it will contain 3 total. cardName is literally the name of the tarot card drawn by the user. starPoint indicates the positivity of the interpretation as a star. The worse the interpretation, the closer it will be to 0, and the more positive the interpretation, the closer it will be to 5. shortComment is a one-line summary of the interpretation. detail is a detailed interpretation of the card. hashTags contains the keywords that the card represents in an array of hashtags.";
    }


    public String createPrompt(List<TarotCard> selectedCards) {
        if (this == STAR_STORY) {
            return createStarStoryPrompt(selectedCards);
        }

        // TODO: 다른 프롬프트 케이스 추가
        return "Prompt Not Found";
    }

    private String createStarStoryPrompt(final List<TarotCard> selectedCards) {
        // 세 개의 카드에 대한 설명을 포함한 프롬프트 생성
        return String.format("제가 뽑은 카드는 다음과 같습니다:\n"
                        + "1. 저는 이 카드를 통해서 오늘의 감정의 흐름을 알아내고 싶습니다. - %s\n"
                        + "2. 저는 이카드를 통해서 오늘의 기회와 장애물에 대한 힌트를 얻고 싶습니다. - %s\n"
                        + "3. 오늘 저의 일과 삶에 대한 조언을 이 카드를 통해 얻고 싶습니다. - %s",
                selectedCards.get(0).getName(),
                selectedCards.get(1).getName(),
                selectedCards.get(2).getName());
    }
}
