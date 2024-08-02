package com.bank.bankops.service

import com.bank.bankops.repository.MovimentacaoRepo
import org.springframework.stereotype.Service

@Service
class MovimentacaoService(private val movimentacaoRepo: MovimentacaoRepo) {
}