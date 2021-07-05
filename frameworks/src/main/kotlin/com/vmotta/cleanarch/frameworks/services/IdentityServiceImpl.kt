package com.vmotta.cleanarch.frameworks.services

import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException
import com.vmotta.cleanarch.usecases.services.IdentityService
import org.springframework.stereotype.Service

@Service
class IdentityServiceImpl : IdentityService {
    override fun validateCpf(cpf: String): Boolean {
        return try {
            CPFValidator().assertValid(cpf)
            true
        } catch (err: InvalidStateException) {
            false
        }
    }
}