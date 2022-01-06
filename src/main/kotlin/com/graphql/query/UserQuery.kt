package com.graphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.graphql.service.UserService
import com.graphql.model.Users
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userService: UserService) : Query {

    @GraphQLDescription("retrieves User from the repository by id")
    fun findUserById(
        @GraphQLDescription("id of the user") id: String
    ): Users = userService.findById(id).get()

    @GraphQLDescription("retrieves all Users from repository")
    fun getAllUsers(): List<Users> = userService.getAllUsers()
}
