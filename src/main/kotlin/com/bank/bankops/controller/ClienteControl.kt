package com.bank.bankops.controller

import com.bank.bankops.service.ClienteService
import com.bank.bankops.dto.ClienteDt
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/clientes")
class ClienteControl {

    private val clienteService: ClienteService

    constructor(clienteService : ClienteService) {
        this.clienteService = clienteService
    }

    /* Usar DTOS
    https://stackoverflow.com/questions/69639251/should-entity-class-be-used-as-request-body
    */
    @PostMapping()
    fun add(@RequestBody cliente : ClienteDt): ResponseEntity<ClienteDt>{
        val addedCliente = clienteService.addCliente(cliente) // atentar para o resultado das requisicoes (pode necessitar arrumar o construtor do cliente)
        return ResponseEntity.status(addedCliente, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getCliente(@PathVariable(value = "id") id : Long): ResponseEntity<ClienteDt>{
        val foundCliente = clienteService.getById(id)
        return ResponseEntity.ok().build(foundCliente) // tratar não encontrado -> ex https://github.com/callicoder/kotlin-spring-boot-jpa-rest-api-demo/blob/master/src/main/kotlin/com/example/kotlindemo/controller/ArticleController.kt
    }
}