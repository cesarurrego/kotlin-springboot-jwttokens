package com.cesarurrego.jwttokens.controller.users

data class UserRequest(
    val email: String,
    val password: String,
)