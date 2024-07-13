package com.bank.bankops.controller

import com.bank.bankops.service.ContaService
import com.bank.bankops.dto.ContaDt
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contas")
class ContaControl(private val contaService: ContaService) {
    //post
    @PostMapping
    fun add(@RequestBody conta: ContaDt): ResponseEntity<ContaDt> {
        val addedConta = contaService.addConta(conta)
        return ResponseEntity.status(HttpStatus.CREATED).body(addedConta)
        /*
        return temporario
        */
    }

    /*
    //get
    @GetMapping("/{id}")
    fun getContaById(@PathVariable(value = "id") id: Long): ResponseEntity<ContaDt> {
        val foundConta = contaService.getById(id) // tratar não encontrado
        return ResponseEntity.ok().build(foundConta)
    }

    //put (update)
    @PutMapping("/{id}")
    fun updateContaById(@PathVariable(value = "id") id: Long, @RequestBody conta: ContaDt): ResponseEntity<ContaDt> {
    // visitar o controller do cliente.
    }

    //delete
    @DeleteMapping("/{id}")
    fun deleteContaById(@PathVariable(value = "id") id: Long): ResponseEntity<ContaDt> {
    // visitar o controller do cliente.
    }
    *
     */
}