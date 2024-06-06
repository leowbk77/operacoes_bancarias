package com.bank.bankops.repository

import com.bank.bankops.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
//jpa crudRepo ...
@Repository
interface clienteRepo : JpaRepository<Cliente, Long> {}