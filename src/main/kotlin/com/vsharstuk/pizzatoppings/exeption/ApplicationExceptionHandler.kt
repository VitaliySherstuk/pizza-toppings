package com.vsharstuk.pizzatoppings.exeption

import com.vsharstuk.pizzatoppings.dto.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class ApplicationExceptionHandler {

    private val log = LoggerFactory.getLogger(ApplicationExceptionHandler::class.java)
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleBadRequestException(exception: EntityNotFoundException): ResponseEntity<ErrorResponse> {
        log.error("Handle bad request exception", exception)
        val errorResponse = ErrorResponse()
        errorResponse.status = HttpStatus.BAD_REQUEST
        errorResponse.message = exception.message
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        log.error("Handle Not Valid Argument exception", exception)
        val errorResponse = ErrorResponse()
        errorResponse.status = HttpStatus.BAD_REQUEST
        errorResponse.message = exception.message
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(exception: Exception): ResponseEntity<ErrorResponse> {
        log.error("Handle unexpected exception", exception)
        val errorResponse = ErrorResponse()
        errorResponse.status = HttpStatus.INTERNAL_SERVER_ERROR
        errorResponse.message = exception.message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse)
    }
}
