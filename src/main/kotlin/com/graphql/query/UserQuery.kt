package com.graphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.graphql.model.Users
import com.graphql.service.UserService
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userService: UserService) : Query {

    @GraphQLDescription("retrieves User from the repository by id")
    fun findUserById(
        @GraphQLDescription("id of the user") id: String
    ): Users = userService.findById(id).get()

    @GraphQLDescription("retrieves all Users from repository")
    fun getAllUsers(): List<Users> = userService.getAllUsers()

    @GraphQLDescription("retrieves User from the repository by name")
    fun findUserByName(
        @GraphQLDescription("name of the user") name: String
    ): List<Users> = userService.findByName(name)
}
