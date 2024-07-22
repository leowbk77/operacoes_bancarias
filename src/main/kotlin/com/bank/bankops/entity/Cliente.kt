package com.bank.bankops.entity

import com.bank.bankops.dto.ClienteDt
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "cliente")
class Cliente(var nome: String,
                var cpf: String,
                var nascimento: LocalDate,
                @Id @GeneratedValue(strategy = GenerationType.AUTO)
                var id: Long? = null) {
    constructor(clienteDt: ClienteDt) : this(clienteDt.nome, clienteDt.cpf, LocalDate.parse(clienteDt.nascimento), clienteDt.id) {
    }

    fun temp(param: String): String {
        return "huehue, $param"
    }
}