package com.vocalabs.age

/**
 * Created by Faizaan on 3/22/2016.
 */
class Simulator {
    val person1 = Person(1, 2003)
    val person2 = Person(1, 2007)
    var finalList = mutableListOf(person1, person2)
    var tempList = listOf(person1, person2)
    fun spawnSimulator (): MutableList<Person> {
        for (i in 0..6)  {
            tempList = tempList.flatMap { it.spawn() }
            finalList.addAll(tempList)
        }
        return finalList
    }

}

fun main (args:Array<String>){
    println(Simulator().spawnSimulator())
}