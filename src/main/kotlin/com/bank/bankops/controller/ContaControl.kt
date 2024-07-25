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
        try {
            return ResponseEntity(contaService.addConta(conta), HttpStatus.CREATED)
        } catch (e: NullPointerException) {
            return ResponseEntity(conta, HttpStatus.BAD_REQUEST)
        } catch (e: OptimisticLockingFailureException) {
            return ResponseEntity(conta, HttpStatus.BAD_REQUEST)
        }
    }

    //get
    @GetMapping("/{id}")
    fun getContaById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        try {
            return ResponseEntity(contaService.getById(id), HttpStatus.OK)
        } catch (: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //put (update)
    @PutMapping()
    fun updateConta(@RequestBody conta: ContaDt): ResponseEntity<Any> {
        try {
            return ResponseEntity(contaService.updateById(conta), HttpStatus.OK)
        } catch (e: NullPointerException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //delete
    @DeleteMapping("/{id}")
    fun deleteContaById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        try {
            return ResponseEntity(contaService.deleteById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}