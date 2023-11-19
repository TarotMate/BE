package com.tarotmate.tarot.domain.article.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class ReadArticleService {

}
