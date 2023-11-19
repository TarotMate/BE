# 베이스 이미지 선택
FROM openjdk:17

LABEL authors="0gun"

# 작업 디렉토리 설정
WORKDIR /app

# 애플리케이션 파일 복사 (여기서는 build/libs/*.jar를 사용)
COPY build/libs/tarot-0.0.1-SNAPSHOT.jar tarotmate-0.1v.jar

# 컨테이너 시작 시 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app/tarotmate-0.1v.jar"]
