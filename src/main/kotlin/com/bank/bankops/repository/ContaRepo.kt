package com.bank.bankops.repository

import com.bank.bankops.entity.Conta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContaRepo : JpaRepository<Conta, Long> {}