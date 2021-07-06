package com.vmotta.cleanarch.entities.person

import java.util.UUID

interface PersonRepository {
    fun save(person: Person) : Person
    fun update(person: Person) : Person
    fun delete(person: Person)
    fun findById(id: UUID) : Person?
    fun findAll() : List<Person>
}