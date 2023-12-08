package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity()
class Cliente(nome: String, cpf: String, nascimento: LocalDateTime) : Pessoa(nome, cpf, nascimento) {
    fun temp(param: String): String {
        return "huehue, $param"
    }
}