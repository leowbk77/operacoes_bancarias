package com.bank.bankops.entity

import com.bank.bankops.dto.ClienteDt
import java.time.LocalDate

@Entity
class Cliente {
    var nome: String = ""
    var cpf: String = ""
    var nascimento: LocalDate? = null
    var id : Long = 0

    constructor(clinteDt : ClienteDt) {
        this.nome = clienteDt.nome
        this.cpf = clienteDt.cpf
        this.nascimento = LocalDate.of(clienteDt.nascimento)
    }

    fun temp(param: String) : String {
        return "huehue, $param"
    }
}