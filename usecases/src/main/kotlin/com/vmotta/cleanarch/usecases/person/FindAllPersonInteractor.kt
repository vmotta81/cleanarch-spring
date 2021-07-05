package com.vmotta.cleanarch.usecases.person

import com.vmotta.cleanarch.usecases.person.response.PersonResponse

interface FindAllPersonInteractor {
    fun execute(): List<PersonResponse>
}