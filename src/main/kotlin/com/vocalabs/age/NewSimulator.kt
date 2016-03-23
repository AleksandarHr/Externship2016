package com.vocalabs.age

import com.vocalabs.util.histogram

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class NewSimulator {
    val parent = NewPerson(1, 2003)

}

fun main (args:Array<String>){
    val people = Simulator().spawnSimulator()
    for (i in 1..7) {
        val peopleInGeneration = people.filter { it.generation == i }
        println("\n\n----- Generation $i ----")
        val datesOfBirth: List<Int> = peopleInGeneration.map{it.dateOfBirth}
        println(histogram(datesOfBirth))
    }
}