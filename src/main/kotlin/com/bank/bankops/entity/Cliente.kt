package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity
class Cliente {
    protected var nome : String = ""
    protected var cpf: String = ""
    protected var nascimento: LocalDateTime? = null
    protected var id : Long = 0

    constructor() {
        
    }

    fun temp(param: String): String {
        return "huehue, $param"
    }
}