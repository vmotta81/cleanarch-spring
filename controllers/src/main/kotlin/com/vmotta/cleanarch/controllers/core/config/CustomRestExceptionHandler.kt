package com.vmotta.cleanarch.controllers.core.config

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant

@ControllerAdvice
class CustomRestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(exception: Exception, request: WebRequest?): ResponseEntity<BaseResponseException> {
        return generateResponseError(
            exception,
            NOT_FOUND,
            getSource(request)
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(
        exception: Exception,
        request: WebRequest?
    ): ResponseEntity<BaseResponseException> {
        return generateResponseError(
            exception,
            BAD_REQUEST,
            getSource(request)
        )
    }

    private fun getSource(request: WebRequest?): String {
        return request?.getDescription(false)?.substring(4) ?: ""
    }

    private fun generateResponseError(
        exception: Throwable,
        status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        source: String
    ): ResponseEntity<BaseResponseException> {
        exception.printStackTrace()
        val baseResponseException = BaseResponseException(
            timestamp = Instant.now(),
            status = status,
            message = exception.message ?: "UNKNOWN_ERROR",
            source = source
        )
        return ResponseEntity(baseResponseException, status)
    }

    data class BaseResponseException(
        val timestamp: Instant,
        val message: String,
        val status: HttpStatus,
        val source: String
    )
}




