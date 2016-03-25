package com.vocalabs.age

import com.vocalabs.util.histogram
import java.util.*
import java.util.HashMap

/**
 * Created by Aleksandar on 24.3.2016 г..
 */
class SimulatorWithMap {
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
    var temp: List<NewPerson>

    // The hashMap 'generationsMap' is the one all generations are stored
    var generationsMap: HashMap<Int, MutableList<Int>>
    var listOfYears: MutableList<Int>

    // Getting the number of simulations to run as user input
    println("How many simulations do you want to run?")
    val numberOfSimulations = readLine()

    // Getting the number of generations as user input and those generations are spawned
    println("How many generations do you want?")
    val numberOfGens = readLine()

    // Asking for output form as user input
    println("Choose an output form: 'csv' or 'histogram'")
    val outputForm = readLine()


    if (numberOfGens is String && numberOfGens.toInt() is Int &&
            numberOfSimulations is String && numberOfSimulations.toInt() is Int) {
        // for loop to run as many times as the number of simulations specified
        for (i in 1..numberOfSimulations.toInt()) {
            temp = listOf(parent)
            generationsMap = HashMap<Int, MutableList<Int>>()
            // for loop to run each simulation as many times as the number of generations specified
            for (j in 0..(numberOfGens.toInt())-1) {
            temp = temp.flatMap {it.giveBirth(
                    it.calculateNumberOfChildren(random.nextGaussian()),
                    it.ageOfFirstBirth(random.nextGaussian()))
            }
            // adding the generations to the map
            listOfYears = mutableListOf<Int>()
            for (k in 0..temp.size - 1) {
                listOfYears.add(temp[k].dateOfBirth)
                generationsMap.put(j, listOfYears)
            }
            }

            // output format
            println("\n\n********** SIMULATION $i **********")
            println("*** Parent from generation 0 with year of birth: " + yearOfBirth)
            for (m in 0..generationsMap.size - 1) {
                println("Generation: " + (m+1) + " years of births: " + generationsMap.get(m))
            }

            // Print as 'csv'
            if (outputForm == "csv") {
                    val lines: List<String> = generationsMap.map { "${it.key+1}, ${it.value}" }
                    println("generation,dateOfBirth \n${lines.joinToString(separator = "\n")}\n\n")
            }
            // Print as a histogram
            else if (outputForm == "histogram") {
                for (p in 0..numberOfGens.toInt()-1) {
                    val peopleInGeneration = generationsMap.filter { it.key == p }
                    println("\n\n----- Generation ${p+1} ----")
                    val datesOfBirth: List<Int> = peopleInGeneration.flatMap { it.value }
                    println(histogram(datesOfBirth)+ "\n\n\n")
                }
            }
        }
    }

    else {
        throw IllegalArgumentException()
    }
}