package com.graphql.expediagraphql.mutation

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.graphql.expediagraphql.UserRepository
import com.graphql.expediagraphql.model.Users
import org.springframework.stereotype.Component

@Component
class UserMutation(private val repository: UserRepository) : Mutation {

    @GraphQLDescription("Add User to the repository")
    fun addUser(user: Users): Users? = repository.save(user)

    @GraphQLDescription("Update existing user in the repository")
    fun updateUser(user: Users): Users? = repository.save(user)

    @GraphQLDescription("Delete user from repository")
    fun deleteUser(id: String): Users? = repository.deleteUser(id)

}
