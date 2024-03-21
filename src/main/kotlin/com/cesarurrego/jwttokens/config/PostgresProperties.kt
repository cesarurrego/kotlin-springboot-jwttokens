package com.cesarurrego.jwttokens.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("postgres")
data class PostgresProperties(
    val url: String,
    val username: String,
    val password: String,
    val driverClassName: String
)