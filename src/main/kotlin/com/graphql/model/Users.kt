package com.graphql.model


import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USERS")
data class Users(@Id val id: String?, val name: String, val username: String, val password: String)
