package com.graphql.query

import com.expediagroup.graphql.server.types.GraphQLRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = ["graphql.packages=com.graphql"]
)
@EnableAutoConfiguration
class UserQueryIT(@Autowired private val testClient: WebTestClient) {

    @Test
    fun `get all Users`() {
        val request = GraphQLRequest(query = "query { getAllUsers{name} }")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.getAllUsers").exists()
            .jsonPath("$.data.getAllUsers[0].name").isEqualTo("Sameer").jsonPath("$.data.getAllUsers[1].name")
            .isEqualTo("Max")
    }

    @Test
    fun `get User by Name`() {
        val request = GraphQLRequest(query = "query { findUserByName(name:\"Sameer\"){name}\n }")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.findUserByName").exists()
            .jsonPath("$.data.findUserByName[0].name").isEqualTo("Sameer")
    }
}
