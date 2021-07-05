package com.vmotta.cleanarch.usecases.person.request

import com.vmotta.cleanarch.entities.person.Person
import java.util.UUID

class CreatePersonRequest(
    val name: String,
    val cpf: String
) {
    constructor(): this("", "")

    fun toDomain(): Person {
        return Person(
            id = UUID.randomUUID(),
            name = name,
            cpf = cpf
        )
    }
}