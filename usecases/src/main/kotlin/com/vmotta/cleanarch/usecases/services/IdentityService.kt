package com.vmotta.cleanarch.usecases.services

interface IdentityService {
    fun validateCpf(cpf: String): Boolean
}