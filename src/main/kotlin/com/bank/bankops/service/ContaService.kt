package com.bank.bankops.service

import com.bank.bankops.repository.ContaRepo
import com.bank.bankops.dto.ContaDt
import com.bank.bankops.entity.Conta
import org.springframework.stereotype.service

@Service
class ContaService(private val contaRepo: ContaRepo) {
    fun addConta(contaDt: ContaDt) : ContaDt {
        var novaConta = Conta(contaDt)
        contaRepo.save(conta)
        return contaDt
    }
}