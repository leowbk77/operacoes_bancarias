package com.bank.bankops.entity

import com.bank.bankops.dto.ContaDt
import java.time.LocalDate
import jakarta.persistence.*

@Entity
class Conta(var dataDeCriacao: LocalDate,
            var saldo: Double,
            var ultimoAcesso: LocalDate,
            var idCliente: Long,
            @Id @GeneratedValue(strategy = GenerationType.AUTO)
            var id: Long) {

    constructor(contaDt: ContaDt) : this(LocalDate.parse(contaDt.dataDeCriacao), contaDt.saldo, LocalDate.parse(contaDt.ultimoAcesso), contaDt.idCliente, contaDt.id) {
    }

    fun temp(param: String) : String{
        return "huehue, $param"
    }
}