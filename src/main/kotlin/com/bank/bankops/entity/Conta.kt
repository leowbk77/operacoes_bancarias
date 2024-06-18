package com.bank.bankops.entity

import com.bank.bankops.dto.ContaDt
import java.time.LocalDate

@Entity
class Conta {
    var dataDeCriacao: LocalDate? = null
    var saldo: Double = 0.0
    var ultimoAcesso: LocalDate? = null
    var id: Long = 0
    var idCliente: Long = 0

    constructor(contaDt : ContaDt) {
        this.dataDeCriacao = contaDt.dataDeCriacao
        this.saldo = contaDt.saldo
        this.ultimoAcesso = contaDt.ultimoAcesso
    }

    fun temp(param: String) : String{
        return "huehue, $param"
    }
}