package com.vmotta.cleanarch.usecases.person.response

import com.vmotta.cleanarch.entities.person.Person
import java.util.UUID

class PersonResponse(
    val id: UUID,
    val name: String,
    val cpf: String
) {
    companion object {
        fun from(person: Person) = PersonResponse(person.id, person.name, person.cpf)
    }
}