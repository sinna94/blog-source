package me.chung.interceptor.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController {
    companion object{
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun interceptorTest(){
        log.info("실제 처리 부분")
    }

    @GetMapping("exclude")
    fun interceptorExcludeTest(){
        log.info("exclude")
    }
}
