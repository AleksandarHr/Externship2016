package com.vocalabs.age
import java.lang.Math
import java.util.Random

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class NewPerson (val generation: Int, var dateOfBirth: Int) {

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

    fun calculateNumberOfChildren(random: Random): Int {
        var numOfChildren = 0
        var gaussian = random.nextGaussian() * 1 + 2.5
        if (gaussian >= 0.0 && gaussian <= 5.0) {
            numOfChildren = Math.round(gaussian).toInt()
        }
        return numOfChildren
    }

    fun giveBirth (numberOfKids: Int, firstBirthAge: Int): kotlin.collections.MutableList<Person> {
        var newGeneration = mutableListOf<Person>()
        if (numberOfKids == 0) {
        }
        else {
            for (i in 0..numberOfKids) {
                var child = Person(this.generation + 1, firstBirthAge)
                when (i) {
                    1 -> child.dateOfBirth = firstBirthAge
                    2 -> child.dateOfBirth = firstBirthAge + 3
                    3 -> child.dateOfBirth = firstBirthAge + 4
                    4 -> child.dateOfBirth = firstBirthAge + 5
                    5 -> child.dateOfBirth = firstBirthAge + 8
                }
                newGeneration.add(child)
            }
        }
        return newGeneration
    }
}