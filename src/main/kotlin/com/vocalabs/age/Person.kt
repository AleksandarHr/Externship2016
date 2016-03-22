package com.vocalabs.age

/**
 * Created by Faizaan on 3/22/2016.
 */
data class Person  (val generation: Int, val dateOfBirth: Int) {
    fun spawn() : List<Person>  {
        val child1 = Person(generation + 1, dateOfBirth + (generation - 1) * 20)
        val child2 = Person(generation + 1, dateOfBirth + (generation - 1) * 25)
        return listOf(child1, child2)
    }
}
