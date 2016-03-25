package com.vocalabs.age

/**
 * Simple histogram front-end for IntelliJ.
 */

fun main(args: Array<String>) {
    val   startYear = 1972
    val generations = 7
    val numberOfSimulations = 1000
    val    consumer = HistogramPersonConsumer(numberOfSimulations.toDouble())
    val mySimulator = Simulator(startYear, generations, consumer)

    val simulationResult = SimulationsRunner(mySimulator).run(numberOfSimulations)
    mySimulator.write(simulationResult)
}