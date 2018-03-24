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
@Configuration
@EnableAutoConfiguration
class BlogApplication {
    private val log = LoggerFactory.getLogger(BlogApplication::class.java)

    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        val repository = context.getBean(CustomerRepository::class.java)

        // save a couple of customers
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))

        // fetch all customers
        val customers = repository.findAll()
        println("Customers found with findAll():")
        println("-------------------------------")
        for (customer in customers) {
            println(customer)
        }
        println()

        // fetch an individual customer by ID
        val customer = repository.findById(1L)
        println("Customer found with findOne(1L):")
        println("--------------------------------")
        println(customer)
        println()

        // fetch customers by last name
        val bauers = repository.findByLastName("Bauer")
        println("Customer found with findByLastName('Bauer'):")
        println("--------------------------------------------")
        for (bauer in bauers) {
            println(bauer)
        }
        context.close()

        return "Hello World!"
    }
}

fun main(args: Array<String>) {
    context = runApplication<BlogApplication>(*args)
}


