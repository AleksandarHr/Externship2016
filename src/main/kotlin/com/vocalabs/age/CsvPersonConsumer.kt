package com.vocalabs.age

import com.vocalabs.util.countDuplicates

/**
 * Prints CSV to standard out.
 */
class CsvPersonConsumer : PersonConsumer {
    override fun read(people: List<NewPerson>) {
        throw UnsupportedOperationException("Not written") // TODO
        //generations.forEach {
        //    println("${it.generation},${it.dateOfBirth},???" )
        //}
    }

    override fun start() {
        println("generation, dob, count")
    }
}