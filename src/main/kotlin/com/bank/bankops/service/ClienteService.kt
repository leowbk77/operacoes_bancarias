package com.bank.bankops.service

import com.bank.bankops.repository.ClienteRepo
import com.bank.bankops.dto.ClienteDt
import com.bank.bankops.entity.Cliente
import org.springframework.stereotype.Service

@Service
class ClienteService(private val clienteRepo: ClienteRepo) {
    fun addCliente(clienteDt: ClienteDt) : ClienteDt{
        var novoCliente = Cliente(clienteDt)
        clienteRepo.save(novoCliente)
        return clienteDt
    }
}