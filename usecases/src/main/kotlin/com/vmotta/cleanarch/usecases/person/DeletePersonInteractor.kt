package com.vmotta.cleanarch.usecases.person

import java.util.UUID

interface DeletePersonInteractor {
    fun execute(id: UUID)
}