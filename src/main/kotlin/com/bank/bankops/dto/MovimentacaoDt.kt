package com.bank.bankops.dto

import com.bank.bankops.entity.Movimentacao
import java.time.LocalDate

data class MovimentacaoDt(val tipo: Int,
                            val origemId: Long,
                            val destinoId: Long,
                            val valor: Double,
                            val dataDeCriacao: LocalDate,
                            val id: Long?) {
    constructor(movimentacao: Movimentacao) : this(movimentacao.tipo, movimentacao.origemId, movimentacao.destinoId, movimentacao.valor, movimentacao.dataDeCriacao, movimentacao.id) {
    }
}
