package com.bank.bankops.entity

import java.time.LocalDateTime

// deixar de ser abstract
// rever esse dataDeCriacao
@Entity
abstract open class Movimentacao {
    protected var origemID : Int = 0
    protected var dataDeCriacao : LocalDateTime = LocalDateTime.now()
}