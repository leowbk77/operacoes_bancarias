package com.bank.bankops.entity

import java.time.LocalDateTime

// mudar os ID`s pra long
// rever o null safety (?)
@Entity
class Movimentacao {
    protected var tipo : Int? = TipoMovimentacao.INDEFINIDA.ordinal
    protected var origemID : Int? = 0
    protected var destinoID : Int? = 0 //transferencia
    protected var valor : Double? = 0.0 
    protected var dataDeCriacao : LocalDateTime? = null

    constructor(origemID: Int, valor: Double, dataDeCriacao: LocalDateTime, tipo: Int) {
		this.origemID = origem
        this.dataDeCriacao = dataDeCriacao
        this.tipo = tipo
    }
    
    constructor(origemID: Int, destinoID: Int, valor: Double, dataDeCriacao: LocalDateTime, tipo: Int) : this(origemID, valor, dataDeCriacao, tipo) {
        this.destinoID = destinoID
    }
}