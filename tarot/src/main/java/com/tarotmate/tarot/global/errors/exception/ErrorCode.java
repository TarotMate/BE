package com.tarotmate.tarot.global.errors.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ER01("ER_01"), // AWS Parameter Store 내에서 OpenAI API Key 호출 실패
    ER02("ER_02"), // 존재하지 않는 타로 카드 번호
    ER03("ER_03"), // 프롬프트 생성 실패
    ER04("ER_04"), // API가 응답은 했으나 OPENAI API에서 비정상적인 응답을 보냄
    ER05("ER_05"), // OPENAI API 응답값 json object 파싱 실패
    ER06("ER_06"), // 타로페이지에서 받은 theme가 잘못되었을 때
    ER07("ER_07"), // 타로페이지에서 받은 fortuneType이 잘못되었을 때
    ER08("ER_08"), // GPT 응답값 파싱 실패
    ER09("ER_09"), // GPT가 생성한 타로 해석의 개수가 사용자가 제공한 description 개수와 다름
    ER10("ER_10"), // 시작 페이지의 초기데이터 매핑 실패
    ER11("ER_11") // 이미 존재하는 이메일로 회원가입 시도
    ;

    private final String code;
}
