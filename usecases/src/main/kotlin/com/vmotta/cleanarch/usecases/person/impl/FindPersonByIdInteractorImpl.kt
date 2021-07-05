package com.vmotta.cleanarch.usecases.person.impl

import com.vmotta.cleanarch.entities.person.PersonRepository
import com.vmotta.cleanarch.usecases.person.FindPersonByIdInteractor
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import java.util.UUID
import javax.inject.Inject
import javax.inject.Named

@Named
class FindPersonByIdInteractorImpl(
    @Inject val personRepository: PersonRepository
) : FindPersonByIdInteractor {
    override fun execute(id: UUID): PersonResponse {
        val person = personRepository.findById(id) ?: throw NoSuchElementException("Person Not Found")
        return PersonResponse.from(person)
    }
}