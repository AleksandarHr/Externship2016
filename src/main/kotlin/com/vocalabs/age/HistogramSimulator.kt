package com.vocalabs.age

/**
 * Simple histogram front-end for IntelliJ.
 */

fun main(args: Array<String>) {
    val   startYear = 2000
    val generations = 7
    val    consumer = HistogramPersonConsumer()
    Simulator(startYear, generations, consumer).run()
}