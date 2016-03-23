package com.vocalabs.age

/**
 * Created by Faizaan on 3/22/2016.
 */
data class Person  (val generation: Int, var dateOfBirth: Int) {

    fun spawn() : List<Person>  {
        val child1 = Person(generation + 1, dateOfBirth + generation * 20)
        val child2 = Person(generation + 1, dateOfBirth + generation * 25)
        return listOf(child1, child2)
    }
}
