package com.bank.bankops.controller

import com.bank.bankops.service.ContaService
import com.bank.bankops.dto.ContaDt
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/contas")
class ContaControl {
    private val contaService: ContaService

    @Autowired
    constructor(contaService: ContaService) {
        this.contaService = contaService
    }

    //post
    @PostMapping

    //get
    @GetMapping("/{id}")
    fun getContaById(@PathVariable(value = "id") id: Long): ResponseEntity<ContaDt> {
        val foundConta = contaService.getById(id) // tratar não encontrado
        return ResponseEntity.ok().build(foundConta)
    }

    //put (update)
    @PutMapping

    //delete
    @DeleteMapping
}