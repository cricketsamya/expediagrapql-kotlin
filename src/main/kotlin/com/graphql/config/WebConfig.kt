package com.graphql.config

import com.graphql.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl


@Configuration //Make this as a configuration class
@EnableWebSecurity //Turn on Web Security
class SecurityWebInitializer : WebSecurityConfigurerAdapter() {

    @Bean
    fun getPasswordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Autowired
    private val userService: UserService? = null
    override fun configure(http: HttpSecurity) {
        http.formLogin().and().logout().logoutSuccessUrl("/").and().rememberMe()
            .tokenRepository(JdbcTokenRepositoryImpl()).tokenValiditySeconds(2419200).key("BurgerBob").and().httpBasic()
            .and().authorizeRequests().antMatchers("/**").authenticated().anyRequest().permitAll()
    }

}
