package com.vocalabs.age

import com.vocalabs.util.histogram
import java.util.*

/**
 * Created by Aleksandar on 24.3.2016 г..
 */
class NewSimulator {
}

fun main (args:Array<String>){
    // Getting the year of birth of the initial parent as user input
    println("Give parent's year of birth")
    val random = Random()
    val yearOfBirth = readLine()
    val yearOfBirthInt: Int
    if (yearOfBirth is String && yearOfBirth.toInt() is Int) {
        yearOfBirthInt = yearOfBirth.toInt()
    }
    else {
        throw IllegalArgumentException()
    }

    // Creates a the initial person (parent) with the given YOB
    val parent = NewPerson (0, yearOfBirthInt)

    // The list 'temp' will store only the new generations born in order to be used
    //    for giving birth to the generations after them
    var temp = listOf(parent)

    // The list 'generations' is the one all generations are stored
    var generations = mutableListOf(parent)

    // Getting the number of simulations to run as user input
    println("How many simulations do you want to run?")
    val numberOfSimulations = readLine()
    // Getting the number of generations as user input and those generations are spawned
    println("How many generations do you want?")
    val numberOfGens = readLine()
    if (numberOfGens is String && numberOfGens.toInt() is Int &&
        numberOfSimulations is String && numberOfSimulations.toInt() is Int) {
        for (i in 1..numberOfSimulations.toInt()) {
            for (j in 0..(numberOfGens.toInt() - 1)) {
                temp = temp.flatMap {
                    it.giveBirth(it.
                            calculateNumberOfChildren(random.nextGaussian()),
                            it.ageOfFirstBirth(random.nextGaussian()))
                }
                generations.addAll(temp)
            }
        }
    }
    else {
        throw IllegalArgumentException()
    }

    // Asking for output form as user input
    println("Choose an output form: 'csv' or 'histogram'")
    val outputForm = readLine()

    // Print as 'csv'
    if (outputForm == "csv") {
        for (i in 1..numberOfSimulations.toInt()) {
            println("\n\n********** SIMULATION $i **********")
            val lines: List<String> = generations.map { "${it.generation},${it.dateOfBirth}" }
            println("generation,dateOfBirth \n${lines.joinToString(separator = "\n")}")
        }
    }

    // Print as a histogram
    else if (outputForm == "histogram") {
            for (i in 0..numberOfGens.toInt()) {
                val peopleInGeneration = generations.filter { it.generation == i }
                println("\n\n----- Generation $i ----")
                val datesOfBirth: List<Int> = peopleInGeneration.map { it.dateOfBirth }
                println(histogram(datesOfBirth))
            }
    }
}