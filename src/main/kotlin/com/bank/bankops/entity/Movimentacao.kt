package com.bank.bankops.entity

import com.bank.bankops.entity.TipoMovimentacao

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "movimentacao")
class Movimentacao(var tipo: Int,
                   var origemID: Long,
                   var destinoID: Long,
                   var valor: Double,
                   var dataDeCriacao: LocalDate,
                   @Id @GeneratedValue(strategy = GenerationType.AUTO)
                   var id: Long?) {
}