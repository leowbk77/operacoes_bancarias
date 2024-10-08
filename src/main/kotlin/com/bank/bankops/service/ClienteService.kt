package com.bank.bankops.service

import com.bank.bankops.repository.ClienteRepo
import com.bank.bankops.dto.ClienteDt
import com.bank.bankops.entity.Cliente
import org.springframework.stereotype.Service

@Service
class ClienteService(private val clienteRepo: ClienteRepo) {

    fun addCliente(clienteDt: ClienteDt): ClienteDt {
        if(clienteDt != null) {
            clienteRepo.save(Cliente(clienteDt))
            return clienteDt
        } else throw NullPointerException()
    }

    fun getById(id: Long): ClienteDt = ClienteDt(clienteRepo.findById(id).get())

    fun updateById(cliente: ClienteDt): ClienteDt {
        val id = cliente.id ?: throw NullPointerException() // joga exception caso id null
        val updated = clienteRepo.findById(id).get() // joga NoSuchElement caso cliente nao encontrado -> https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html
        return ClienteDt(clienteRepo.saveAndFlush(Cliente(cliente)))
    }

    fun deleteById(id: Long): ClienteDt {
        val deleted = clienteRepo.findById(id).get()
        clienteRepo.deleteById(id)
        return ClienteDt(deleted)
    }
}