package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity
class Deposito(
                protected var origemID : Int,
                protected var valor : Double,
                protected var dataDeCriacao : LocalDateTime) : Movimentacao(origemID, dataDeCriacao) {
}