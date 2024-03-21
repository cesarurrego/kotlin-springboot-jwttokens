package com.cesarurrego.jwttokens.repository

import com.cesarurrego.jwttokens.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ArticleRepository: JpaRepository<Article, UUID>