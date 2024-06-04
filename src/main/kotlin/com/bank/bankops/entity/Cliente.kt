package com.bank.bankops.entity

import java.time.LocalDateTime
import 

@Entity                               // mudar essa var nascimento
class Cliente {

    protected var nome : String
    protected var cpf: String
    protected var nascimento: LocalDateTime
    protected var id : Long

    constructor()

    fun temp(param: String): String {
        return "huehue, $param"
    }
}