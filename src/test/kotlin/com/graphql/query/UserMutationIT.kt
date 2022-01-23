package com.graphql.query

import com.expediagroup.graphql.server.types.GraphQLRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = ["graphql.packages=com.graphql"]
)
@EnableAutoConfiguration
class UserMutationIT(@Autowired private val testClient: WebTestClient) {

    @Test
    fun `add a user`() {
        val request =
            GraphQLRequest(query = "mutation addUser { addUser(user: { name: \"matty\", password: \"asss\", username: \"mattis\" }) { name,username } }")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.addUser").exists()
            .jsonPath("$.data.addUser.name").isEqualTo("matty").jsonPath("$.data.addUser.username").isEqualTo("mattis")
    }

    @Test
    fun `update a user`() {
        val request =
            GraphQLRequest(query = "mutation updateUser { updateUser(user: { id: \"1\", name: \"matty\", password: \"asss\", username: \"mattis\" }) { id,name,username } }")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.updateUser").exists()
            .jsonPath("$.data.updateUser.name").isEqualTo("matty").jsonPath("$.data.updateUser.username")
            .isEqualTo("mattis").jsonPath("$.data.updateUser.id").isEqualTo("1")
    }

    @Test
    fun `delete a user`() {
        val request = GraphQLRequest(query = "mutation deleteUser { deleteUser(id:\"1\") { id }}")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.deleteUser").exists()
            .jsonPath("$.data.deleteUser.id").isEqualTo("1")
    }

    @Test
    fun `delete a non existing user `() {
        val request = GraphQLRequest(query = "mutation deleteUser { deleteUser(id:\"100\") { id }}")
        testClient.post().uri("/graphql").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request).exchange().expectBody().jsonPath("$.data.deleteUser").doesNotExist()
            .jsonPath("$.errors[0].message").isEqualTo("Exception while fetching data (/deleteUser) : No value present")
    }
}
