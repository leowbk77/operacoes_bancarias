package com.bank.bankops.controller

import com.bank.bankops.dt.MensagemTempDt

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
// Este é um controler teste
//Ele já retorna um JSON no "/" com os dados da data class
//
@RestController
class FirstTempControl() {
    @GetMapping("/")
    fun index() = listOf(
            MensagemTempDt(1, "Um"),
            MensagemTempDt(2, "Dois"),
            MensagemTempDt(3, "Tres"),
        )
}