package com.vmotta.cleanarch.usecases.person

import com.vmotta.cleanarch.usecases.person.request.CreatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse

interface CreatePersonInteractor {
    fun execute(request: CreatePersonRequest): PersonResponse
}