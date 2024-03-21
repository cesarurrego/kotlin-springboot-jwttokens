package com.cesarurrego.jwttokens.repository

import com.cesarurrego.jwttokens.model.Role
import com.cesarurrego.jwttokens.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {
    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            email = "admin@bimbly.com",
            password = encoder.encode("123456"),
            role = Role.ADMIN
        ), User(
            id = UUID.randomUUID(),
            email = "user@bimbly.com",
            password = encoder.encode("123456"),
            role = Role.USER
        ), User(
            id = UUID.randomUUID(),
            email = "user2@bimbly.com",
            password = encoder.encode("123456"),
            role = Role.USER
        )
    )

    fun save(user: User): Boolean {
        val updatedUser = user.copy(
            password = encoder.encode(user.password)
        )
        return this.users.add(updatedUser)
    }

    fun findByEmail(email: String?): User? = this.users.find { it.email == email }

    fun findById(id: UUID): User? = this.users.find { it.id == id }

    fun findAll(): List<User> = this.users

    fun deleteById(id: UUID): Boolean {
        val foundUser = this.users.find { it.id == id }
        return foundUser?.let {
            users.remove(it)
        } ?: false
    }
}