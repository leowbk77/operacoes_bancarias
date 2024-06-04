package com.bank.bankops.dt

import java.time.LocalDateTime

class ClienteDt(
                protected val nome: String, 
                protected val cpf: String, 
                protected val nascimento: LocalDateTime,
                protected val id : Long ) {}

/*
    DATA CLASS PROVAVELMENTE DESCARTAVEIS
 */