package com.tarotmate.tarot.global.utils.prompt;

import com.tarotmate.tarot.global.errors.exception.ErrorCode;
import com.tarotmate.tarot.global.errors.exception.Exception400;
import com.tarotmate.tarot.global.utils.InitPage;
import com.tarotmate.tarot.global.utils.TarotCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

public class FortunePrompt {

    public static String getBasicSystemPrompt(){
        return "You are very good at interpreting tarot cards. Please freely interpret the user's situation regarding the tarot cards.";
    }

    public static String getFortuneTypeInfo(final String fortuneType, final String theme){
        switch (fortuneType) {
            case InitPage.TODAY_TAROT -> {
                return (Objects.equals("하루의 마무리", theme)) ? "I want to know what I learned from today, what I'm grateful for that I hadn't thought about, and what I can do to have a better tomorrow." : "I want to predict how the day will go.";
            }
            case InitPage.LOVE_TAROT -> {
                if (Objects.equals("이별 후의 회복", theme)) return "I recently broke up with my partner. I wonder what I should do for the future.";
                else if (Objects.equals("관계의 발전", theme))
                    return "There's someone I've been interested in recently. I would like to see a fortune telling about my relationship with that person.";
                else return "I want to find new love.";
            }
            case InitPage.TAROT_OF_THE_MONTH -> {
                if (Objects.equals("개인적 성장과 발전", theme))
                    return "I'm wondering what I should do this month for my personal growth and development.";
                else if (Objects.equals("월간 관계 동향", theme))
                    return "I'm curious about how my relationships with other people will go this month.";
                else return "I want to know and react to what major events will occur this month.";
            }
            default -> throw new Exception400(ErrorCode.ER07.getCode());
        }
    }

//    public static String getReturnTypeSetting() {
//
//        // JSON 객체 생성
//        final JSONObject fortuneObject = new JSONObject();
//        final JSONArray fortuneArray = new JSONArray();
//
//        // 카드 정보를 담은 JSON 객체 생성
//        final JSONObject cardInfo = new JSONObject();
//        cardInfo.put("cardName", "운명의 수레바퀴 (Wheel of Fortune)");
//        cardInfo.put("starRating", 4);
//        cardInfo.put("shortComment", "오늘은 연인과의 관계가 깊이 있게 발전할 수 있습니다.");
//        cardInfo.put("detail", "상세적인 카드 해석");
//
//        // 해시태그 배열 생성
//        final JSONArray hashTags = new JSONArray();
//        hashTags.add("#변화의 필요성");
//        hashTags.add("#전환점");
//        hashTags.add("#행운");
//        hashTags.add("#필연성");
//        cardInfo.put("hashTag", hashTags);
//
//        // JSON 배열에 카드 정보 추가
//        fortuneArray.add(cardInfo);
//
//        // 최종 JSON 객체에 배열 추가
//        fortuneObject.put("fortune", fortuneArray);
//
//        // JSON 객체를 문자열로 변환
//        return "Ask the model to provide a response in JSON format. Do not say anything other than the JSON response value. Here is Json example: " + fortuneObject.toString();
//    }

    public static String getAdditionalExplain() {
        return "The following is an explanation of the JSON key you must give when responding. fortune is an array containing interpretations for each card. cardName is literally the name of the tarot card drawn by the user. starRating indicates the positivity of the interpretation as a star. The worse the interpretation, the closer it will be to 1, and the more positive the interpretation, the closer it will be to 5. The star rating is an integer. shortComment is a one-line summary of the detail. detail is a detailed interpretation of the card. hashTags contains the keywords that the card represents in an array of hashtags.";
    }


    public static String createUserPrompt(final List<TarotCard> selectedCards, final List<String> cardDescriptions) {

        // 리스트 길이 확인
        if (selectedCards.size() != cardDescriptions.size()) {
            throw new IllegalArgumentException("카드 목록과 설명 목록의 길이가 일치하지 않습니다.");
        }

        // 메시지 생성
        final StringBuilder promptBuilder = new StringBuilder("제가 뽑은 카드는 다음과 같습니다:\n");
        for (int i = 0; i < selectedCards.size(); i++) {
            promptBuilder.append(String.format("%d. 저는 이 카드를 뽑을 때 '%s'에 대한 정보를 얻고 싶다고 생각했습니다. - %s\n",
                    i + 1, cardDescriptions.get(i), selectedCards.get(i).getName()));
        }
        return promptBuilder.toString();
    }

    public static String responseLanguageSetting() {
        return "Follow these three instructions below in all your responses: 1. Your customers are koreans, so please use Korean language only; 2. Use Korean alphabet whenever possible;3. Translate any other language to the Korean language whenever possible.;";
    }
}
