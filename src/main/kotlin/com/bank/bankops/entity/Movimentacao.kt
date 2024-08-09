package com.bank.bankops.entity

import com.bank.bankops.dto.MovimentacaoDt
import com.bank.bankops.entity.TipoMovimentacao

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "movimentacao")
class Movimentacao(var tipo: Int,
                   var origemId: Long,
                   var destinoId: Long,
                   var valor: Double,
                   var dataDeCriacao: LocalDate,
                   @Id @GeneratedValue(strategy = GenerationType.AUTO)
                   var id: Long?) {
    constructor(movimentacao: MovimentacaoDt) : this(movimentacao.tipo, movimentacao.origemId, movimentacao.destinoId, movimentacao.valor, movimentacao.dataDeCriacao, movimentacao.id)
}