package com.bank.bankops.dt

import java.time.LocalDateTime

class Conta (
             protected var dataDeCriacao: LocalDateTime,
             protected var saldo: Double,
             protected var ultimoAcesso: LocalDateTime,
             protected var id: Int,
             protected var idCliente: Int) {}