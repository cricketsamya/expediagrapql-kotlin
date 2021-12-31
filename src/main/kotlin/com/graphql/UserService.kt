package com.graphql

import com.graphql.model.Users
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val repository: UserRepository) {

    fun deleteUser(id: String): Users? {
        var user = repository.findById(id)
        if (user.isPresent) {
            repository.deleteById(id)
        }
        return user.get()
    }

    fun save(user: Users): Users? = repository.save(user)
    fun findById(id: String): Optional<Users> = repository.findById(id)
    fun getAllUsers(): List<Users> = repository.getAllUsers()
}
