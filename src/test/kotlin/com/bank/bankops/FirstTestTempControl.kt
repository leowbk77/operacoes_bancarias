package com.bank.bankops

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
class FirstTempControl {

    @Autowired
    private val controller : FirstTempControl
    
	@Test
	fun tempTest() {
	}
}