package com.graphql.service

import com.graphql.model.Users
import com.graphql.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val repository: UserRepository) : UserDetailsService {

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

    override fun loadUserByUsername(s: String): UserDetails {
        val user = repository.findByUsername(s)
        //.orElseThrow { UsernameNotFoundException("The username $s doesn't exist") }
        val authorities = ArrayList<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("STANDARD_USER"))
        return User(
            user.get(0).username, user.get(0).password, authorities
        )
    }
}
