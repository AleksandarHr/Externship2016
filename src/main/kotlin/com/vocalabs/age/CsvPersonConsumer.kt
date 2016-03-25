package com.vocalabs.age

/**
 * Prints CSV to standard out.
 */
class CsvPersonConsumer : PersonConsumer {
    override fun read(generations: List<NewPerson>) {
        generations.forEach { println("${it.generation},${it.dateOfBirth}" )}
    }

    override fun start() {
        println("generation, dob")
    }
}