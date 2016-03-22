package com.vocalabs.age

/**
 * Created by Faizaan on 3/22/2016.
 */
class Simulator {
    val person1 = Person(1, 2003)
    val person2 = Person(1, 2007)
    val list1 = mutableListOf(person1, person2)
    fun simualator ()  {
    for (i in 1..7)  {
        val listnew = listOf<Person>()
        list1.flatMapTo(listnew, {it.spawn()})




}}