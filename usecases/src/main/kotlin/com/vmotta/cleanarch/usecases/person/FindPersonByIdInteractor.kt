package com.vmotta.cleanarch.usecases.person

import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import java.util.UUID

interface FindPersonByIdInteractor {
    fun execute(id: UUID): PersonResponse
}