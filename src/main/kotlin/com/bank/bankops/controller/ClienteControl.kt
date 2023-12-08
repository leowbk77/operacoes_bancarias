package com.bank.bankops.controller

import com.bank.bankops.service.ClienteService // tbadd

import org.springframework.web.bind.annotation.RestController

@RestController
class ClienteControl(private val cliente : ClienteService){}