package com.tarotmate.tarot.global.errors.exception;

public enum ErrorCode {
    ;

    // AWS Parameter Store 내에서 OpenAI API Key 호출 실패
    public static final String ER01 = "ER01";

    // 존재하지 않는 타로 카드 번호
    public static final String ER02 = "ER02";

    // 프롬프트 생성 실패
    public static final String ER03 = "ER03";

    // API가 응답은 했으나 OPENAI API에서 비정상적인 응답을 보냄
    public static final String ER04 = "ER04";

    // OPENAI API 응답값 json object 파싱 실패
    public static final String ER05 = "ER05";

    // 타로페이지에서 받은 theme가 잘못되었을 때
    public static final String ER06 = "ER06";

    // 타로페이지에서 받은 fortuneType이 잘못되었을 때
    public static final String ER07 = "ER07";

    // GPT 응답값 파싱 실패
    public static final String ER08 = "ER08";

    // GPT가 생성한 타로 해석의 개수가 사용자가 제공한 description 개수와 다름
    public static final String ER09 = "ER09";

    // 초기데이터 매핑 실패
    public static final String ER10 = "ER10";
}
