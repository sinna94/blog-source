package chung.study

import org.junit.jupiter.api.Test
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.primaryConstructor

internal class PersonTest {

    @Test
    fun testPersonReflection() {
        println("생성자 조회")
        println(Person::class.constructors)

        println("call 을 이용한 생성")
        Person::class.primaryConstructor?.call("홍길동", 30)?.let {
            println(it)
        }

//        println("call 을 이용한 생성 (기본값)")
//        Person::class.primaryConstructor?.call("홍길동")?.let {
//            println(it)
//        }

        val nameKParameter = Person::class.primaryConstructor?.findParameterByName("name")
        val ageKParameter = Person::class.primaryConstructor?.findParameterByName("age")
        if (nameKParameter != null && ageKParameter != null) {
            println("callBy 를 이용한 생성")
            Person::class.primaryConstructor?.callBy(mapOf(nameKParameter to "홍길동", ageKParameter to 30))?.let {
                println(it)
            }
            println("callBy 를 이용한 생성 (순서 상관 없다)")
            Person::class.primaryConstructor?.callBy(mapOf(ageKParameter to 30, nameKParameter to "홍길동"))?.let {
                println(it)
            }
            println("callBy 를 이용한 생성 (기본값)")
            Person::class.primaryConstructor?.callBy(mapOf(nameKParameter to "홍길동"))?.let {
                println(it)
            }
        }
    }
}