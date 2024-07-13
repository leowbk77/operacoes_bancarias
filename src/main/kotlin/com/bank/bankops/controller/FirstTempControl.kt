package com.bank.bankops.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
// Este é um controler teste
//Ele já retorna um JSON no "/" com os dados da data class
//

data class MensagemTempDt(var id: Long, var string: String)

@RestController
class FirstTempControl() {
    @GetMapping("/")
    fun index() = listOf(
            MensagemTempDt(1, "Um"),
            MensagemTempDt(2, "Dois"),
            MensagemTempDt(3, "Tres"),
        )

    @GetMapping("/test")
    fun teste() = listOf(
        MensagemTempDt(0, "GET"),
        MensagemTempDt(1, "teste"),
    )
}