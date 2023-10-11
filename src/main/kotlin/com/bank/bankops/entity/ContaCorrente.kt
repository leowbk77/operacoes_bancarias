package com.bank.bankops.entity

import java.time.LocalDateTime

class ContaCorrente(
                    dataDeCriacao: LocalDateTime,
                    saldo: Double,
                    ultimoAcesso: LocalDateTime,
                    id: Int) : Conta(dataDeCriacao, saldo, ultimoAcesso, id) {
    fun temp(param: String): String {
        return "huehue, $param"
    }
}