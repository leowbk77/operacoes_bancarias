package com.bank.bankops.controller

import com.bank.bankops.service.ClienteService
import com.bank.bankops.dto.ClienteDt
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
class ClienteControl(private val clienteService: ClienteService) {
    // post
    @PostMapping()
    fun add(@RequestBody cliente: ClienteDt): ResponseEntity<ClienteDt> {
        return try {
            ResponseEntity(clienteService.addCliente(cliente), HttpStatus.CREATED) // -> https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
        } catch (e: NullPointerException) {
            ResponseEntity(cliente, HttpStatus.BAD_REQUEST)
        } catch (e: OptimisticLockingFailureException) {
            ResponseEntity(cliente, HttpStatus.BAD_REQUEST)
        }
    }

    // get
    @GetMapping("/{id}")
    fun getClienteById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(clienteService.getById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // put (update)
    @PutMapping()
    fun updateCliente(@RequestBody cliente: ClienteDt): ResponseEntity<Any> {
        return try {
            ResponseEntity(clienteService.updateById(cliente), HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // delete
    @DeleteMapping("/{id}")
    fun deleteClienteById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(clienteService.deleteById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}