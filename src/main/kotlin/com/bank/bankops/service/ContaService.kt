package com.bank.bankops.service

import com.bank.bankops.repository.ContaRepo
import com.bank.bankops.dto.ContaDt
import com.bank.bankops.entity.Conta
import org.springframework.stereotype.Service

@Service
class ContaService(private val contaRepo: ContaRepo) {
    fun addConta(contaDt: ContaDt) : ContaDt {
        contaRepo.save(Conta(contaDt))
        return contaDt
    }
}