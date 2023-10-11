package com.bank.bankops.entity

import java.time.LocalDateTime
// id ?
open abstract class Conta (protected dataDeCriacao: LocalDateTime,
                            protected saldo: Double,
                            protected ultimoAcesso: LocalDateTime,
                            protected id: Int) {

}