package com.vmotta.cleanarch.controllers.person

import com.vmotta.cleanarch.usecases.person.CreatePersonInteractor
import com.vmotta.cleanarch.usecases.person.DeletePersonInteractor
import com.vmotta.cleanarch.usecases.person.FindAllPersonInteractor
import com.vmotta.cleanarch.usecases.person.FindPersonByIdInteractor
import com.vmotta.cleanarch.usecases.person.UpdatePersonInteractor
import com.vmotta.cleanarch.usecases.person.request.CreatePersonRequest
import com.vmotta.cleanarch.usecases.person.request.UpdatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("people")
class PersonController(
    private val createPersonInteractor: CreatePersonInteractor,
    private val updatePersonInteractor: UpdatePersonInteractor,
    private val deletePersonInteractor: DeletePersonInteractor,
    private val findAllPersonInteractor: FindAllPersonInteractor,
    private val findPersonByIdInteractor: FindPersonByIdInteractor
) {
    @PostMapping()
    fun save(@RequestBody request: CreatePersonRequest): PersonResponse {
        return createPersonInteractor.execute(request)
    }

    @PutMapping()
    fun update(@RequestBody request: UpdatePersonRequest): PersonResponse {
        return updatePersonInteractor.execute(request)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: UUID) {
        return deletePersonInteractor.execute(id)
    }

    @GetMapping()
    fun findAll(): List<PersonResponse> {
        return findAllPersonInteractor.execute()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): PersonResponse {
        return findPersonByIdInteractor.execute(id)
    }
}