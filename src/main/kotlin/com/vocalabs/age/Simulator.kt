package com.vocalabs.age

/**
 * Created by Faizaan on 3/22/2016.
 */
class Simulator {
    val person1 = Person(1, 2003)
    val person2 = Person(1, 2007)
    var finalList = mutableListOf(person1, person2)
    var tempList = mutableListOf(person1, person2)
    fun simulator ()  {
        for (i in 1..7)  {
            tempList.flatMapTo(tempList, {it.spawn()})
            finalList.addAll(tempList)
        }
    }
}