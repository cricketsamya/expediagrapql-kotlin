package com.graphql.expediagraphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.graphql.expediagraphql.UserRepository
import com.graphql.expediagraphql.model.Users
import org.springframework.stereotype.Component

@Component
class UserQuery(private val repository: UserRepository) : Query {

    @GraphQLDescription("retrieves User from the repository by id")
    fun findUserById(
        @GraphQLDescription("id of the user") id: String
    ): Users = repository.findById(id).get()

    @GraphQLDescription("retrieves all Users from repository")
    fun getAllUsers(): List<Users> = repository.getAllUsers()
}
