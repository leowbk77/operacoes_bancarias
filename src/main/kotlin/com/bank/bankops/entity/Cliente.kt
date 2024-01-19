package com.bank.bankops.entity

import java.time.LocalDateTime
import 

@Entity                               // mudar essa var nascimento
class Cliente(

                protected val nome: String, 
                protected val cpf: String, 
                protected val nascimento: LocalDateTime,
                protected val id : Long ) {
    fun temp(param: String): String {
        return "huehue, $param"
    }
}