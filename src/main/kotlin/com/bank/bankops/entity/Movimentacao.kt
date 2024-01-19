package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity
abstract open class Movimentacao(protected var origemID : Int, protected var dataDeCriacao : LocalDateTime){}