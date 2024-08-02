package com.bank.bankops.repository

import com.bank.bankops.entity.Movimentacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovimentacaoRepo:  JpaRepository<Movimentacao, Long> {}