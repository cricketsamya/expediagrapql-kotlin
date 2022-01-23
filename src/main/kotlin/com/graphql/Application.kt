package com.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)

    router {
        GET("/graphql") { request ->
            request.principal().map { it.name }.map { ServerResponse.ok().body(mapOf("greeting" to "Hello $it")) }
                .orElseGet { ServerResponse.badRequest().build() }
        }
    }
}
