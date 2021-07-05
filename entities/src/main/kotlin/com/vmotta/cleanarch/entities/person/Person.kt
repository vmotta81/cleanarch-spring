package com.vmotta.cleanarch.entities.person

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "people")
data class Person(
    @Id
    val id: UUID,
    val name: String,
    val cpf: String
) {
    constructor(): this(UUID.randomUUID(), "", "")
}