package com.bank.bankops.dto

import com.bank.bankops.entity.Cliente
import java.time.LocalDate

data class ClienteDt(val nome: String,
                    val cpf: String,
                    // recebe como string e transforma em dateTime no service
                    val nascimento: String,
                    var id: Long?) {
    constructor(cliente: Cliente) : this(cliente.nome, cliente.cpf, cliente.nascimento.toString(), cliente.id) {
    }
}