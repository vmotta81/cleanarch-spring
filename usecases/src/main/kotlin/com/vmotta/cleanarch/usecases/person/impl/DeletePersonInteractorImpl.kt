package com.vmotta.cleanarch.usecases.person.impl

import com.vmotta.cleanarch.entities.person.PersonRepository
import com.vmotta.cleanarch.usecases.person.DeletePersonInteractor
import java.util.UUID
import javax.inject.Inject
import javax.inject.Named

@Named
class DeletePersonInteractorImpl(
    @Inject val personRepository: PersonRepository
) : DeletePersonInteractor {
    override fun execute(id: UUID) {
        val person = personRepository.findById(id) ?: throw NoSuchElementException("Person not found")
        personRepository.delete(person)
    }
}