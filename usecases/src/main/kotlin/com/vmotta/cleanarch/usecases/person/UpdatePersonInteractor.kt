package com.vmotta.cleanarch.usecases.person

import com.vmotta.cleanarch.usecases.person.request.UpdatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse

interface UpdatePersonInteractor {
    fun execute(request: UpdatePersonRequest): PersonResponse
}