package com.cesarurrego.jwttokens.service

import com.cesarurrego.jwttokens.model.Article
import com.cesarurrego.jwttokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    fun findAll(): List<Article> = articleRepository.findAll()

    fun save(article: Article): Article = articleRepository.save(article)
}