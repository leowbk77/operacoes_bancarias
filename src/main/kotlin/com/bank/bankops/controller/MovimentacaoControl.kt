package com.bank.bankops.controller

import com.bank.bankops.service.MovimentacaoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mov")
class MovimentacaoControl(private val movimentacaoService: MovimentacaoService) {

}