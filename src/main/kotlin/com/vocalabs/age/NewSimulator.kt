package com.vocalabs.age

import com.vocalabs.util.histogram
import java.util.*

/**
 * Created by Aleksandar on 24.3.2016 г..
 */
class NewSimulator {
}

fun main (args:Array<String>){
    println("Give parent's year of birth")
    val random = Random()
    val yearOfBirth = readLine()
    val yearOfBirthInt: Int
    if (yearOfBirth is String) {
        if (yearOfBirth.toInt() is Int) {
            yearOfBirthInt = yearOfBirth.toInt()
        } else {
            throw IllegalArgumentException()
        }
    }
    else {
        throw IllegalArgumentException()
    }

    val parent = NewPerson (0, yearOfBirthInt)
    var temp = listOf(parent)
    var generations = mutableListOf(parent)
    println("How many generations do you want?")
    val numberOfGens = readLine()
    if (numberOfGens is String) {
        if (numberOfGens.toInt() is Int) {
            for (i in 0..(numberOfGens.toInt() - 1)) {
                temp = temp.flatMap { it.giveBirth(it.
                                                    calculateNumberOfChildren(random.nextGaussian()),
                                                    it.ageOfFirstBirth(random.nextGaussian())) }
                generations.addAll(temp)
            }
        }
        else {
            throw IllegalArgumentException()
        }
    }
    else {
        throw IllegalArgumentException()
    }

    println("Choose an output form: 'cvs' or 'histogram'")
    val outputForm = readLine()
    if (outputForm == "cvs") {
        //val myList = listOf<Person>(Person(1,2007),(Person(1,2003)),(Person(2,2004)))
        //val people = newSimulator().spawnSimulator()
        val lines: List<String> = generations.map { "${it.generation},${it.dateOfBirth}" }
        println("generation,dateOfBirth \n${lines.joinToString(separator = "\n")}")
    }
    else if (outputForm == "histogram") {
        for (i in 0..numberOfGens.toInt()) {
            val peopleInGeneration = generations.filter { it.generation == i }
            println("\n\n----- Generation $i ----")
            val datesOfBirth: List<Int> = peopleInGeneration.map{it.dateOfBirth}
            println(histogram(datesOfBirth))
        }
    }

}