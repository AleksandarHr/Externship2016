package com.vocalabs.age
import java.lang.Math
import java.util.Random

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class NewPerson (val generation: Int, var dateOfBirth: Int) {

    val random = Random()
    val doubleRandom = random.nextDouble()
    val gaussianRandom = random.nextGaussian()

    fun willGiveBirth (chance: Double): Boolean {
        if (chance > 0.47) {
            return true
        }
        else {
            return false
        }
    }

    fun ageOfFirstBirth (gaussian: Double): Int {
        var age: Int
        age = Math.round(gaussian * 12 + 27).toInt()
        if (age < 15) {
            age = 15
        }
        else if (age > 70) {
            age = 70
        }
        return age
    }

    fun yearOfFirstBirth (dateOfBirth: Int, firstBirthAt: Int): Int {
        return dateOfBirth + firstBirthAt
    }

    fun calculateNumberOfChildren(gaussianDouble: Double): Int {
        var numOfChildren = 0
        var gaussian = gaussianDouble * 1 + 2.5
        if (gaussian >= 0.0 && gaussian <= 5.0) {
            numOfChildren = Math.round(gaussian).toInt()
        }
        return numOfChildren
    }

    fun giveBirth (numberOfKids: Int, firstBirthAge: Int): kotlin.collections.MutableList<NewPerson> {
        var newGeneration = mutableListOf<NewPerson>()
        if (numberOfKids <= 0) {
            println("No kids will be born from the person from generation: " + this.generation)
            println("and year of birth: " + this.dateOfBirth)
        }
        else if (numberOfKids > 5) {
            println("Too many kids")
        }
        else {
            for (i in 1..numberOfKids) {
                var child = NewPerson(this.generation + 1, firstBirthAge)
                when (i) {
                    1 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge)
                    2 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 3
                    3 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 4
                    4 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 5
                    5 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 8
                }
                newGeneration.add(child)
            }
        }
        return newGeneration
    }


}