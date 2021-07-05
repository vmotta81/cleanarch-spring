package com.vmotta.cleanarch.usecases.person.impl

import com.vmotta.cleanarch.entities.person.PersonRepository
import com.vmotta.cleanarch.usecases.person.CreatePersonInteractor
import com.vmotta.cleanarch.usecases.person.request.CreatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import com.vmotta.cleanarch.usecases.services.IdentityService
import javax.inject.Inject
import javax.inject.Named

@Named
class CreatePersonInteractorImpl(
    @Inject val personRepository: PersonRepository,
    @Inject val identityService: IdentityService
) : CreatePersonInteractor {
    override fun execute(request: CreatePersonRequest): PersonResponse {
        val person = request.toDomain()
        if (!identityService.validateCpf(person.cpf)) throw IllegalArgumentException("Invalid CPF")
        val newPerson = personRepository.save(person)
        return PersonResponse.from(newPerson)
    }
}