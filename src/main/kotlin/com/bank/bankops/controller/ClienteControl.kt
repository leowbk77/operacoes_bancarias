package com.bank.bankops.controller

import com.bank.bankops.service.ClienteService
import com.bank.bankops.dto.ClienteDt
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

/* TUTO
https://medium.com/collabcode/boas-pr%C3%A1ticas-para-a-implementa%C3%A7%C3%A3o-de-apis-no-spring-boot-com-kotlin-6e77aac110da
 */
@RestController
@RequestMapping("/clientes")
class ClienteControl(private val clienteService: ClienteService) {
    /*
        Atentar para a injeção de dependencia nos construtores
        Evitar criação de novos objetos a cada request
     */

    /* Usar DTOS
    https://stackoverflow.com/questions/69639251/should-entity-class-be-used-as-request-body
    */
    // post
    @PostMapping()
    fun add(@RequestBody cliente: ClienteDt): ResponseEntity<ClienteDt> {
        try {
            return ResponseEntity(clienteService.addCliente(cliente), HttpStatus.CREATED) // -> https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
        } catch (e: ResponseStatusException) { // exception temporaria
            return ResponseEntity(cliente, e.statusCode)
        }
    }

    // get
    @GetMapping("/{id}")
    fun getClienteById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        try {
            return ResponseEntity(clienteService.getById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // put (update)
    @PutMapping()
    fun updateClienteById(@RequestBody cliente: ClienteDt): ResponseEntity<Any> {
        try {
            return ResponseEntity(clienteService.updateById(cliente), HttpStatus.OK)
        } catch (e: NullPointerException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // delete
    @DeleteMapping("/{id}")
    fun deleteClienteById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        try {
            return ResponseEntity(clienteService.deleteById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}