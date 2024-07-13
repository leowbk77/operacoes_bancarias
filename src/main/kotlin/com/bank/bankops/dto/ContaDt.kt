package com.bank.bankops.dto

import com.bank.bankops.entity.Conta
import java.time.LocalDate

data class ContaDt(val saldo: Double,
                    val ultimoAcesso: String,
                    val dataDeCriacao: String,
                    val idCliente: Long,
                    var id: Long?) {
    constructor(conta: Conta) : this(conta.saldo, conta.ultimoAcesso.toString(), conta.dataDeCriacao.toString(), conta.idCliente, conta.id){
    }
}