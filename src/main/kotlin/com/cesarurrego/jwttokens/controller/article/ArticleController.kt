package com.cesarurrego.jwttokens.controller.article

import com.cesarurrego.jwttokens.model.Article
import com.cesarurrego.jwttokens.service.ArticleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/article")
class ArticleController(
    private val articleService: ArticleService
) {

    @GetMapping
    fun listAll(): List<ArticleResponse> = articleService.findAll()
        .map { it.toResponse() }

    @PostMapping
    fun create(@RequestBody articleRequest: ArticleRequest): ArticleResponse =
        articleService.save(
            article = articleRequest.toModel()
        ).toResponse()
//            ?: throw ResponseStatusException(
//                HttpStatus.BAD_REQUEST, "Cannot create an article"


    private fun ArticleRequest.toModel(): Article = Article(
        title = title,
        content = content
    )

    private fun Article.toResponse():ArticleResponse = ArticleResponse(
        id = this.id,
        title = this.title,
        content = this.content,
    )
}