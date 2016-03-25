package com.vocalabs.age
import java.util.*

/** Runs a Simulator and merges the results of each. */
class SimulationsRunner(val simulator: Simulator) : SimulationRun {

    val random = Random()
    override fun runGeneration(previousGeneration: Iterable<Person>): List<Person> {
        val newGeneration = previousGeneration.flatMap {
            it.giveBirth(
                    it.calculateNumberOfChildren(random.nextGaussian()),
                    it.ageOfFirstBirth(random))
        }
       return newGeneration
    }

    override fun runSimulation(simulator: Simulator): TreeMap<Int, List<Person>> {
       return simulator.run()
    }

    /**
     * Run multiple simulations and return a map of generations to a count of each
     * person per year. I.e. Map(generation) -> people.
     */
    fun run(numberOfSimulations: Int): TreeMap<Int, List<Person>> {
        var finalMap = TreeMap<Int, List<Person>>()
        for (i in 0..numberOfSimulations-1) {
            runSimulation(simulator)
                    .forEach { generation, people ->
                        val peopleFromFinalMap = finalMap[generation] ?: listOf<Person>()
                        val allPeople = peopleFromFinalMap + people
                        finalMap.put(generation, allPeople)
                    }
        }
        return finalMap
    }
}