package com.vocalabs.age
import java.util.*

/**
 * Old simulator
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

    // ---------------------------------------------------------------------------------

    println("How many generations do you want?")
    val numberOfGens = readLine()!!.toInt()

    Simulator(yearOfBirthInt, numberOfGens, consumer).run()
}

class Simulator(val yearOfBirthInt: Int, val numberOfGens: Int, val consumer: PersonConsumer) {
    fun run() {
        val random = Random()
        val parent = Person (0, yearOfBirthInt)
        var temp = listOf(parent)
        var generations = listOf(parent)
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
}