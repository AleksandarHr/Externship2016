package com.vocalabs.age

/**
 * Created by Faizaan on 3/24/2016.
 */
fun main (args:Array<String>) {
    val myList = listOf<Person>(Person(1,2007),(Person(1,2003)),(Person(2,2004)))
    //val people = newSimulator().spawnSimulator()
    val lines: List<String> = myList.map{"${it.generation},${it.dateOfBirth}"}
    println("generation,dateOfBirth \n${lines.joinToString(separator = "\n")}")

}

