package com.bank.bankops.entity

import java.time.LocalDateTime

open abstract class Pessoa(protected nome: String,
                            protected cpf: String,
                            protected nascimento: LocalDateTime) {
}