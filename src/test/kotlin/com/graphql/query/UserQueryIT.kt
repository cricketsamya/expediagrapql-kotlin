/*
 * Copyright 2021 Expedia, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
}
