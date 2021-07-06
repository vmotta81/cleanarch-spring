package com.vmotta.cleanarch.usecases.person.impl

import com.vmotta.cleanarch.entities.person.PersonRepository
import com.vmotta.cleanarch.usecases.person.UpdatePersonInteractor
import com.vmotta.cleanarch.usecases.person.request.UpdatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import javax.inject.Inject
import javax.inject.Named

@Named
class UpdatePersonInteractorImpl(
    @Inject val personRepository: PersonRepository
) : UpdatePersonInteractor {
    override fun execute(request: UpdatePersonRequest): PersonResponse {
        val person = request.toDomain()
        val found = personRepository.findById(person.id) ?: throw NoSuchElementException("Person Not Found")
        val personUpdated = personRepository.update(found.copy(name = person.name))
        return PersonResponse.from(personUpdated)
    }
}