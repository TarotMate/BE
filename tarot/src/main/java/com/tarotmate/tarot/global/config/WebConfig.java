package com.tarotmate.tarot.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정 적용
                .allowedOrigins("https://tarotmate.kr", "https://www.tarotmate.kr",  "http://localhost:5173") // 여기서는 tarotmate.kr 도메인에서의 요청만 허용
                .allowedMethods("GET", "POST") // 허용할 HTTP 메소드 명시
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true) // 인증 정보 허용 (예: 쿠키, HTTP 인증)
                .maxAge(3600); // 3600초 동안 pre-flight 결과 캐시
    }
}
