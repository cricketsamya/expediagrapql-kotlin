package com.graphql.mutation

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.graphql.UserService
import com.graphql.model.Users
import org.springframework.stereotype.Component

@Component
class UserMutation(private val userService: UserService) : Mutation {

    @GraphQLDescription("Add User to the repository")
    fun addUser(user: Users): Users? = userService.save(user)

    @GraphQLDescription("Update existing user in the repository")
    fun updateUser(user: Users): Users? = userService.save(user)

    @GraphQLDescription("Delete user from repository")
    fun deleteUser(id: String): Users? = userService.deleteUser(id)
}
