package com.tarotmate.tarot.domain.article.ui;

import com.tarotmate.tarot.global.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    @GetMapping("/articles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> readArticles() {
        return ApiResult.success(null);
    }

    @PostMapping("/articles")
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> createArticles() {
        return ApiResult.success(null);
    }
}
