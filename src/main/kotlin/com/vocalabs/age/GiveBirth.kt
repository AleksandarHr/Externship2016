package com.vocalabs.age

import java.lang.Math
import java.util.*

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class GiveBirth (parent: Person) {

    fun willGiveBirth (): Boolean {
        val random = Random()
        var chance = random.nextDouble()

        if (chance > 0.47) {
            return true
        }
        else {
            return false
        }
    }

    fun ageOfFirstBirth (): Int {
        var age: Int
        val random = Random()
        age = Math.round(random.nextGaussian() * 12 + 27).toInt()
        return age
    }

}