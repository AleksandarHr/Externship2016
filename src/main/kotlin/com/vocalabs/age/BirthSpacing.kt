package com.vocalabs.age

import scala.collection.mutable.MutableList
import java.awt.List

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class BirthSpacing (parent: Person) {
    var newGeneration = mutableListOf<Person>()
    fun giveBirth (generation: Int, dateOfBirth: Int, numberOfKids: Int, firstBirthAge: Int): kotlin.collections.MutableList<Person> {
        if (numberOfKids == 0) {
        }
        else {
            for (i in 0..numberOfKids) {
                var child = Person(generation + 1, dateOfBirth)
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