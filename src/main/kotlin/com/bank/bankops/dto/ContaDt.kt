package com.bank.bankops.dto

import com.bank.bankops.entity.Conta
import java.time.LocalDateTime

data class ContaDt(val saldo: Double,
                    val ultimoAcesso: String,
                    val dataDeCriacao: String,
                    val idCliente: Long) {
    var id: Long = 0

    constructor(conta : Conta) {
    }
}