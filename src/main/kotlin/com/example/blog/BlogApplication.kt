package com.example.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import jdk.nashorn.internal.objects.NativeArray.forEach
import com.example.blog.hello.Customer
import com.example.blog.hello.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean


@Controller
@SpringBootApplication
class BlogApplication {
    private val log = LoggerFactory.getLogger(BlogApplication::class.java)

    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hello World!"
    }

    @Bean
    fun demo(repository: CustomerRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            // save a couple of customers
            repository.save(Customer("Jack", "Bauer"))
            repository.save(Customer("Chloe", "O'Brian"))
            repository.save(Customer("Kim", "Bauer"))
            repository.save(Customer("David", "Palmer"))
            repository.save(Customer("Michelle", "Dessler"))

            // fetch all customers
            log.info("Customers found with findAll():")
            log.info("-------------------------------")
            for (customer in repository.findAll()) {
                log.info(customer.toString())
            }
            log.info("")

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent { customer ->
                        log.info("Customer found with findById(1L):")
                        log.info("--------------------------------")
                        log.info(customer.toString())
                        log.info("")
                    }

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):")
            log.info("--------------------------------------------")
            repository.findByLastName("Bauer").forEach { bauer -> log.info(bauer.toString()) }
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("")
        }
    }


}
fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}


