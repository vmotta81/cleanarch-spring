package com.vmotta.cleanarch.usecases.person.request

import com.vmotta.cleanarch.entities.person.Person
import java.util.UUID

class UpdatePersonRequest(
    val id: UUID,
    val name: String,
    val cpf: String
) {
    constructor() : this(UUID.randomUUID(), "", "")

    fun toDomain(): Person {
        return Person(
            id = id,
            name = name,
            cpf = cpf
        )
    }
}