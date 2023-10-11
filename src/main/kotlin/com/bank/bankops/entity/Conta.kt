package com.bank.bankops.entity

import java.time.LocalDateTime
// id ?
abstract class Conta (
                        protected var dataDeCriacao: LocalDateTime,
                        protected var saldo: Double,
                        protected var ultimoAcesso: LocalDateTime,
                        protected var id: Int) {

}