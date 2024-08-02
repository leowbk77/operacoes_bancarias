package com.bank.bankops.controller

import com.bank.bankops.service.ContaService
import com.bank.bankops.dto.ContaDt
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contas")
class ContaControl(private val contaService: ContaService) {
    //post
    @PostMapping
    fun add(@RequestBody conta: ContaDt): ResponseEntity<ContaDt> {
        return try {
            ResponseEntity(contaService.addConta(conta), HttpStatus.CREATED)
        } catch (e: NullPointerException) {
            ResponseEntity(conta, HttpStatus.BAD_REQUEST)
        } catch (e: OptimisticLockingFailureException) {
            ResponseEntity(conta, HttpStatus.BAD_REQUEST)
        }
    }

    //get
    @GetMapping("/{id}")
    fun getContaById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(contaService.getById(id), HttpStatus.OK)
        } catch (: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //put (update)
    @PutMapping()
    fun updateConta(@RequestBody conta: ContaDt): ResponseEntity<Any> {
        return try {
            ResponseEntity(contaService.updateById(conta), HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //delete
    @DeleteMapping("/{id}")
    fun deleteContaById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(contaService.deleteById(id), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}