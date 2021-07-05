package com.vmotta.cleanarch.usecases.person.impl

import com.vmotta.cleanarch.entities.person.PersonRepository
import com.vmotta.cleanarch.usecases.person.FindAllPersonInteractor
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import javax.inject.Inject
import javax.inject.Named

@Named
class FindAllPersonInteractorImpl(
    @Inject val personRepository: PersonRepository
) : FindAllPersonInteractor {
    override fun execute(): List<PersonResponse> {
        return personRepository.findAll().map {
            PersonResponse.from(it)
        }
    }
}