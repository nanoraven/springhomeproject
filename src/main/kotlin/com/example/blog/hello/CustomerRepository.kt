package com.example.blog.hello

import org.springframework.data.repository.CrudRepository

class CustomerRepository: CrudRepository<Customer, Long> {

    fun findByLastName(lastName:String):List<Customer>
}