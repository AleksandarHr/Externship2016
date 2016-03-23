package com.vocalabs.age

import java.lang.Math
import java.util.*

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class GiveBirth (parent: Person) {
    val random = Random()
    var chance = random.nextDouble()

    fun willGiveBirth () {
        var giveBirth = false
        if (chance > 0.47) {
            giveBirth = true
        }
    }

    fun ageOfFirstBirth (): Int {
        var age: Int
        val random = Random()
        age = Math.round(random.nextGaussian() * 27 + 12).toInt()
        return age
    }
}