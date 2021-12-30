package com.graphql.expediagraphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.graphql.expediagraphql.UserRepository
import com.graphql.expediagraphql.model.Users
import org.springframework.stereotype.Component

@Component
class UserQuery(private val repository: UserRepository) : Query {

    @GraphQLDescription("retrieves User from the repository by ID")
    fun findUserById(
        @GraphQLDescription("The special ingredient") id: String
    ): Users {
        var user = repository.findById(id)
        return user.get()
    }

    @GraphQLDescription("retrieves all Users from repository")
    fun getAllUsers(): List<Users> = repository.getAllUsers()
}
