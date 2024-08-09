package com.bank.bankops.service

import com.bank.bankops.dto.MovimentacaoDt
import com.bank.bankops.entity.Conta
import com.bank.bankops.entity.Movimentacao
import com.bank.bankops.entity.TipoMovimentacao
import com.bank.bankops.repository.ContaRepo
import com.bank.bankops.repository.MovimentacaoRepo
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import kotlin.reflect.full.NoSuchPropertyException

@Service
class MovimentacaoService(private val movimentacaoRepo: MovimentacaoRepo, private val contaRepo: ContaRepo) {
    fun deposit(movimentacao: MovimentacaoDt) {
        if(movimentacao.tipo == TipoMovimentacao.DEPOSITO.ordinal) {
            val destination: Conta = contaRepo.findById(movimentacao.destinoId).get()
            destination.saldo += movimentacao.valor
            movimentacaoRepo.save(Movimentacao(movimentacao))
            contaRepo.saveAndFlush(destination)
        } else throw NoSuchPropertyException()
    }

    fun withdraw(movimentacao: MovimentacaoDt) {
        if(movimentacao.tipo == TipoMovimentacao.SAQUE.ordinal) {
            val origin: Conta = contaRepo.findById(movimentacao.origemId).get()
            if ((origin.saldo - movimentacao.valor) < 0.0) throw IllegalArgumentException() // criar um novo exception?
                else origin.saldo -= movimentacao.valor
            movimentacaoRepo.save(Movimentacao(movimentacao))
            contaRepo.saveAndFlush(origin)
        } else throw NoSuchPropertyException()
    }

    fun transfer(movimentacao: MovimentacaoDt) {
        if(movimentacao.tipo == TipoMovimentacao.TRANSFERENCIA.ordinal) {
            val origin: Conta = contaRepo.findById(movimentacao.origemId).get()
            if ((origin.saldo - movimentacao.valor) < 0.0) {
                throw IllegalArgumentException()
            } else {
                val destination: Conta = contaRepo.findById(movimentacao.destinoId).get()
                origin.saldo -= movimentacao.valor
                destination.saldo += movimentacao.valor
                val accounts = listOf(origin, destination)
                movimentacaoRepo.save(Movimentacao(movimentacao))
                contaRepo.saveAllAndFlush(accounts)
            }
        } else throw NoSuchPropertyException()
    }
}