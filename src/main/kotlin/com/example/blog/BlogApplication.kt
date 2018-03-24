package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import com.example.blog.hello.Customer
import com.example.blog.hello.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.ConfigurableApplicationContext

lateinit var context: ConfigurableApplicationContext
@Controller
@SpringBootApplication
@EnableAutoConfiguration
class BlogApplication {
    private val log = LoggerFactory.getLogger(BlogApplication::class.java)

    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hello World!"
    }
}

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}


