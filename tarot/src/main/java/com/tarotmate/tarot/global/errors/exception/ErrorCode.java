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
}
