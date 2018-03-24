package com.example.blog.hello

import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Customer(val firstName: String,val lastName: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null


    override fun toString(): String {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName)
    }
}