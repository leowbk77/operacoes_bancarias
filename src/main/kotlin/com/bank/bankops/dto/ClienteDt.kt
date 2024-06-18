package com.bank.bankops.dto

import com.bank.bankops.entity.Cliente
import java.time.LocalDateTime

data class ClienteDt(val nome: String,
                    val cpf: String,
                    // recebe como string e transforma em dateTime no service
                    val nascimento: String) {
    var id: Long = 0

    constructor(cliente : Cliente) {
        this.nome = cliente.nome
        this.cpf = cliente.cpf
        this.nascimento = cliente.nascimento.toString()
        this.id = cliente.id
    }
}