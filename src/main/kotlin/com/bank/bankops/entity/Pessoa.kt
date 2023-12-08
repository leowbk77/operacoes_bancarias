package com.bank.bankops.entity

import java.time.LocalDateTime

@Entity
abstract open class Pessoa(
                        protected var nome: String,
                        protected var cpf: String,
                        protected var nascimento: LocalDateTime) {
}