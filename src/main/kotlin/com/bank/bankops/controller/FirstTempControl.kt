package com.bank.bankops.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
// Este é um controler teste


/* TUTO
https://medium.com/collabcode/boas-pr%C3%A1ticas-para-a-implementa%C3%A7%C3%A3o-de-apis-no-spring-boot-com-kotlin-6e77aac110da
 */

data class MensagemTempDt(var id: Long, var string: String)

@RestController
class FirstTempControl() {
    /*
        Atentar para a injeção de dependencia nos construtores
        Evitar criação de novos objetos a cada request
     */

    /* Usar DTOS
    https://stackoverflow.com/questions/69639251/should-entity-class-be-used-as-request-body
    */

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

    @GetMapping("/respentt")
    fun respentt(): ResponseEntity<Any> = ResponseEntity(MensagemTempDt(200, "OK"), HttpStatus.OK)
}