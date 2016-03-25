package com.vocalabs.age

import com.vocalabs.util.histogram

/**
 * Prints Histogram to standard out.
 */
class HistogramPersonConsumer : PersonConsumer {
    var currentGeneration = 0
    override fun read(peopleInGeneration: List<NewPerson>) {
        currentGeneration++
        println("\n\n----- Generation $currentGeneration ----")
        val datesOfBirth: List<Int> = peopleInGeneration.map { it.dateOfBirth }
        println(histogram(datesOfBirth))

    }


}