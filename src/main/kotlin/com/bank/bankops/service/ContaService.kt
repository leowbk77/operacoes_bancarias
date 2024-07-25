package com.bank.bankops.service

import com.bank.bankops.repository.ContaRepo
import com.bank.bankops.dto.ContaDt
import com.bank.bankops.entity.Conta
import org.springframework.stereotype.Service

@Service
class ContaService(private val contaRepo: ContaRepo) {

    fun addConta(contaDt: ContaDt) : ContaDt {
        if(contaDt != null) {
            contaRepo.save(Conta(contaDt))
            return contaDt
        } else throw NullPointerException()
    }

    fun getById(id: Long): ContaDt = ContaDt(clienteRepo.findById(id).get())

    fun updateById(conta: ContaDt): ContaDt {
        val id = conta.id ?: throw NullPointerException()
        val updated = contaRepo.findById(id).get()
        return ContaDt(contaRepo.saveAndFlush(Conta(contaDt)))
    }

    // joga NoSuchElement (linha 28) se o id for invalido
    fun deleteById(id: Long): ContaDt {
        val deleted = contaRepo.findById(id).get()
        contaRepo.deleteById(id)
        return ContaDt(deleted)
    }
}