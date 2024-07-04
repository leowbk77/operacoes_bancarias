package com.bank.bankops.entity

import com.bank.bankops.dto.ContaDt
import java.time.LocalDate
import jakarta.persistence.*

@Entity
class Conta {
    var dataDeCriacao: LocalDate? = null
    var saldo: Double = 0.0
    var ultimoAcesso: LocalDate? = null
    var idCliente: Long = 0
    @Id @GeneratedValue(GenerationType.AUTO)
    var id: Long = 0

    constructor(contaDt: ContaDt) {
        this.dataDeCriacao = contaDt.dataDeCriacao
        this.saldo = contaDt.saldo
        this.ultimoAcesso = contaDt.ultimoAcesso
    }

    fun temp(param: String) : String{
        return "huehue, $param"
    }
}