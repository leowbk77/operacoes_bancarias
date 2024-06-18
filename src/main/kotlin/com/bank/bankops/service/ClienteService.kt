package com.bank.bankops.service

import com.bank.bankops.repository.ClienteRepo
import org.springframework.stereotype.Service;

@Service
class ClienteService {
    private val clienteRepo: ClienteRepo

    constructor(clienteRepo : ClienteRepo) {
        this.clienteRepo = clienteRepo
    }

    fun addCliente(clienteDt : ClienteDt){
        var cliente = Cliente(clienteDt)
        clienteRepo.save(cliente)
    }
}