package backend

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    SpringApplication.run(BackendApplication::class.java, *args)
}

@Bean
fun objectMapper() = ObjectMapper()
        .findAndRegisterModules()!!
