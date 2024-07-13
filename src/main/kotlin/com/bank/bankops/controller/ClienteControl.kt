package com.bank.bankops.controller

import com.bank.bankops.service.ClienteService
import com.bank.bankops.dto.ClienteDt
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/* TUTO
https://medium.com/collabcode/boas-pr%C3%A1ticas-para-a-implementa%C3%A7%C3%A3o-de-apis-no-spring-boot-com-kotlin-6e77aac110da
 */
@RestController
@RequestMapping("/clientes")
class ClienteControl(private val clienteService: ClienteService) {
    /*
        Atentar para a injeção de dependencia nos construtores
        Evitar criação de novos objetos a cada request
     */

    /* Usar DTOS
    https://stackoverflow.com/questions/69639251/should-entity-class-be-used-as-request-body
    */
    // post
    @PostMapping()
    fun add(@RequestBody cliente: ClienteDt): ResponseEntity<ClienteDt> {
        val addedCliente = clienteService.addCliente(cliente)
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCliente)
        /*
        retorno temporario até arrumar algo que faça sentido
        * */
    }

    // get
    @GetMapping("/{id}")
    fun getClienteById(@PathVariable(value = "id") id: Long): ResponseEntity<ClienteDt>{
        val foundCliente = clienteService.getById(id)
        return ResponseEntity.ok().body(foundCliente)
        // tratar não encontrado -> ex https://github.com/callicoder/kotlin-spring-boot-jpa-rest-api-demo/blob/master/src/main/kotlin/com/example/kotlindemo/controller/ArticleController.kt
    }

    // put (update)
    /*
    @PutMapping("/{id}")
    fun updateClienteById(@PathVariable(value = "id") id: Long, @RequestBody cliente: ClienteDt): ResponseEntity<ClienteDt>{
        if(clienteService.existsById(id)){ // a verificacao pode ir pra dentro do service
            return ResponseEntity.ok().body(clienteService.updateClienteById(id, cliente)) // clienteDt já tem o id 
        }
        return ResponseEntity.notFound().build()
    }

    // delete
    @DeleteMapping("/{id}")
    fun deleteClienteById(@PathVariable(value = "id") id: Long, @RequestBody cliente: ClienteDt): ResponseEntity<ClienteDt>{
        /*
        Atentar para o update, mesma ideia.
        Também não há necessidade de receber o DTO pela requisicao.
        */
        if(clienteService.existsById(id)){
            clienteService.deleteClienteById(id)
            return ResponseEntity.ok()
        }
        return ResponseEntity.notFound().build()
    }
    */
}