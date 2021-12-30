package com.graphql.expediagraphql

import com.graphql.expediagraphql.model.Users
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface UserRepository : CrudRepository<Users, String> {

    @Query("select * from users")
    fun getAllUsers(): List<Users>

}
