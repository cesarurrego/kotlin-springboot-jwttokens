package com.cesarurrego.jwttokens.service

import com.cesarurrego.jwttokens.model.User
import com.cesarurrego.jwttokens.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if(found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByEmail(email: String): User? = userRepository.findByEmail(email)

    fun findByID(id: UUID): User? = userRepository.findById(id)

    fun findAll(): List<User> = userRepository.findAll()

    fun deleteUser(id: UUID): Boolean = userRepository.deleteById(id)
}