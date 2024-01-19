package com.bank.bankops.service

import com.bank.bankops.repository.ClienteRepo

import org.springframework.stereotype.Service;

@Service
class ClienteService(private val clienteRepo : ClienteRepo){
    fun addCliente(clienteDt : ClienteDt){
        var cliente = Cliente()
        clienteRepo.save???(cliente)
    }
}