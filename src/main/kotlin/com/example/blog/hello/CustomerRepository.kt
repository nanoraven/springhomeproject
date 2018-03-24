package com.example.blog.hello

import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<Customer, Long> {

    fun findByLastName(lastName:String):List<Customer>
}