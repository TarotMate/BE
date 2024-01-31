package com.tarotmate.tarot.global.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarotmate.tarot.domain.fortune.application.model.FortuneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OpenAIResponseMapper {
    @Mapping(target = "fortune", source = "content.fortune")
    FortuneResponse toFortuneResponse(Content content);

//    default Content toContent(final OpenAIResponse.Choice choice) {
//        final ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.readValue(choice.getMessage().getContent(), Content.class);
//        } catch (JsonMappingException e) {
//            throw new RuntimeException(e);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e); // 적절한 예외 처리를 수행해야 합니다.
//        }
//    }
    @Mapping(target = "starPoint", source = "starRating")
    FortuneResponse.Card toCard(Content.CardInfo cardInfo);
}
