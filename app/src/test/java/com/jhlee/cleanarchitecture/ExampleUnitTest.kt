package com.jhlee.cleanarchitecture

import junit.framework.TestCase.assertEquals
import org.junit.Test

interface Skill {
    fun useSkill(): String
}

class ThunderSkill : Skill {
    override fun useSkill() = "백만볼트~~~~"
}

class FireSkill : Skill {
    override fun useSkill(): String {
        return "받아랏 불대문자!"
    }
}

class Pokemon(private val skill: Skill) {
    fun useSkill(): String {
        return skill.useSkill()
    }
}
class Pikachu {
    private val skill: Skill
    constructor() {
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