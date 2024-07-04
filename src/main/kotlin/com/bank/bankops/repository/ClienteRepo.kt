package com.bank.bankops.repository

import com.bank.bankops.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
https://docs.spring.io/spring-data/jpa/reference/repositories/core-concepts.html
 */

@Repository
interface ClienteRepo: JpaRepository<Cliente, Long> {}