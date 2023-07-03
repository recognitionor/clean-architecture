package com.jhlee.cleanarchitecture

import junit.framework.TestCase.assertEquals
import org.junit.Test

/* 스킬 인터페이스 정의
    기술을 사용하는 함수
*/
interface Skill {
    fun useSkill(): String
}

// 스킬을 상속받아 번개 스킬 사용하는 클래스 구현
class ThunderSkill : Skill {
    override fun useSkill() = "백만볼트~~~~"
}

// 스킬을 상속받아 불 스킬 사용하는 클래스 구현
class FireSkill : Skill {
    override fun useSkill(): String {
        return "받아랏 불대문자!"
    }
}
// 포켓몬 클래스를 생성하는데 생성자로 스킬 객체를 전달 받아
// useSkil 에서 전달 받은 객체를 통해 기술 발동

// DI 패턴을 사용
class Pokemon(private val skill: Skill) {
    fun useSkill(): String {
        return skill.useSkill()
    }
}

// DI 패턴이 아닌 피카추 클래스 내에서 번개스킬을 갖고 있는경우
// 피카추가 타입이 불로 변경 된경우 대대적인 코드의 수정이 들어가야한다.
class Pikachu() {
    private val skill: Skill

    init {
        this.skill = ThunderSkill()
    }
    fun useSkill(): String {
        return skill.useSkill()
    }
}


class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {

        val thunderSkill = ThunderSkill()
        val fireSkill = FireSkill()

        val pikachu = Pokemon(thunderSkill)
        val charizard = Pokemon(fireSkill)

        val p = pikachu.useSkill()    // 출력: Using Thunder skill!
        val c = charizard.useSkill()  // 출력: Using Fire skill!
        assertEquals("Using Thunder skill!", p)

        assertEquals("Using Fire skill!", c)
    }
}