package com.vocalabs.age

import java.lang.Math
import java.util.Random

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class GiveBirth (parent: Person) {

    fun willGiveBirth (random: Random): Boolean {
        var chance = random.nextDouble()

        if (chance > 0.47) {
            return true
        }
        else {
            return false
        }
    }

    fun ageOfFirstBirth (random: Random): Int {
        var age: Int

        age = Math.round(random.nextGaussian() * 12 + 27).toInt()
        return age
    }

}