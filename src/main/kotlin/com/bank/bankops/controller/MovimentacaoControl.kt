package com.bank.bankops.controller

import com.bank.bankops.dto.MovimentacaoDt
import com.bank.bankops.service.MovimentacaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mov")
class MovimentacaoControl(private val movimentacaoService: MovimentacaoService) {
    @PostMapping("/deposit")
    fun deposit(@RequestBody movimentacao: MovimentacaoDt): ResponseEntity<Any> {
        return try {
            movimentacaoService.deposit(movimentacao)
            ResponseEntity(HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestBody movimentacao: MovimentacaoDt): ResponseEntity<Any> {
        return try {
            movimentacaoService.withdraw(movimentacao)
            ResponseEntity(HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("transfer")
    fun transfer(@RequestBody movimentacao: MovimentacaoDt): ResponseEntity<Any> {
        return try {
            movimentacaoService.transfer(movimentacao)
            ResponseEntity(HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}