package com.bank.bankops.service

import com.bank.bankops.repository.ContaRepo
import com.bank.bankops.dto.ContaDt
import org.springframework.stereotype.service

@Service
class ContaService {
    private val clienteRepo: ClienteRepo

    constructor(clienteRepo: ClienteRepo) {
        this.clienteRepo = clienteRepo
    }

    fun addConta(contaDt: ContaDt) {
        var novaConta = Conta(contaDt)
        contaRepo.save(conta)
    }
}