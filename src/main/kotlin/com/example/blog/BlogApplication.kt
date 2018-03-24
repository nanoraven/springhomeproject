package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@SpringBootApplication
class BlogApplication {
    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hello World!"
    }


}
fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}


