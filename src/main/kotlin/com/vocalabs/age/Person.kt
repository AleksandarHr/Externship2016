package com.vocalabs.age
import java.lang.Math
import java.util.*

/**
 * Models human reproduction
 */
data class Person(val generation: Int,
                  val dateOfBirth: Int,
                  val minAgeAtFirstChild: Int = 15,
                  val maxAgeAtFirstChild: Int = 70) {

    fun willGiveBirth (chance: Double): Boolean = chance > 0.47

    fun ageOfFirstBirth (rand: Random): Int {
        val age = Math.round(rand.nextGaussian() * 12 + 27).toInt()
        return when {
            age < minAgeAtFirstChild -> ageOfFirstBirth(rand)
            age > maxAgeAtFirstChild -> ageOfFirstBirth(rand)
            else -> age
        }
    }

    fun yearOfFirstBirth (dateOfBirth: Int, firstBirthAt: Int): Int {
        return dateOfBirth + firstBirthAt
    }

    fun calculateNumberOfChildren(gaussianDouble: Double): Int {
        val numOfChildren = 0
        val gaussian = gaussianDouble * 1 + 2.5
        if (gaussian in 0.0..5.0) {
            return Math.round(gaussian).toInt()
        }
        return numOfChildren
    }

    fun giveBirth (numberOfKids: Int, firstBirthAge: Int): kotlin.collections.MutableList<Person> {
        var newGeneration = mutableListOf<Person>()
        // Number of kids below 0 is not considered and
        //    number of kids above 5 is statistically rare enough to ignore
        if (numberOfKids in 1..5) {
            for (i in 1..numberOfKids) {
                val birthDate: Int = when (i) {
                    1 -> yearOfFirstBirth(dateOfBirth, firstBirthAge)
                    2 -> yearOfFirstBirth(dateOfBirth, firstBirthAge) + 3
                    3 -> yearOfFirstBirth(dateOfBirth, firstBirthAge) + 4
                    4 -> yearOfFirstBirth(dateOfBirth, firstBirthAge) + 5
                    5 -> yearOfFirstBirth(dateOfBirth, firstBirthAge) + 8
                    else -> firstBirthAge
                }
                val child = Person(this.generation + 1, birthDate)
                newGeneration.add(child)
            }
        }
        return newGeneration
    }


}