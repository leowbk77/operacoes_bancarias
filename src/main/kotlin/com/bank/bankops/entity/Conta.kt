package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity
class Conta {
    protected var dataDeCriacao: LocalDateTime? = null
    protected var saldo: Double = 0.0
    protected var ultimoAcesso: LocalDateTime? = null
    protected var id: Long = 0
    protected var idCliente: Long = 0

    constructor() {
        
    }

    fun temp(param: String){
        return "huehue, $param"
    }
}