package com.vocalabs.age

import com.vocalabs.util.histogram
import java.util.*

/**
 * Created by Aleksandar on 24.3.2016 г..
 */
fun main(args: Array<String>) {
    println("Choose an output form: 'csv' or 'histogram'")
    val outputForm = readLine()
    val consumer = when (outputForm) {
        "csv" -> CsvPersonConsumer()
        "histogram" -> HistogramPersonConsumer()
        else -> throw Exception("Unknown form $outputForm")
    }
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
    } else {
        throw IllegalArgumentException()
    }

    val parent = NewPerson (0, yearOfBirthInt)
    var temp = listOf(parent)
    var generations = listOf(parent)
    println("How many generations do you want?")
    val numberOfGens = readLine()!!.toInt()
    for (i in 0..(numberOfGens.toInt() - 1)) {
        temp = temp.flatMap {
            it.giveBirth(it.
                    calculateNumberOfChildren(random.nextGaussian()),
                    it.ageOfFirstBirth(random.nextGaussian()))
        }
        generations += (temp)
    }
    consumer.start()
    for (i in 1..numberOfGens) {
        val currentGen = generations.filter { it.generation == i }
        consumer.read(currentGen)
    }
    consumer.end()


}