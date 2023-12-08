package com.bank.bankops.entity

import java.time.LocalDateTime
// id ?
@Entity
class Conta (
             protected var dataDeCriacao: LocalDateTime,
             protected var saldo: Double,
             protected var ultimoAcesso: LocalDateTime,
             protected var id: Int) {
                
        fun temp(param: String){
            return "huehue, $param"
        }
}