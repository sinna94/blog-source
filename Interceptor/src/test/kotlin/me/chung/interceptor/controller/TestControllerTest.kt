package me.chung.interceptor.controller

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(TestController::class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class TestControllerTest(
    private val mockMvc: MockMvc
) {

    @Test
    fun interceptorTest() {
        mockMvc.get("/test")
        mockMvc.get("/test/exclude")
    }
}
