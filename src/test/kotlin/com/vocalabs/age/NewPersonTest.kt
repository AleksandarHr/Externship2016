package com.vocalabs.age

import org.junit.Test
import java.util.Random

import org.junit.Assert.*

/**
 * Created by Aleksandar on 23.3.2016 г..
 */
class NewPersonTest {
    val random = Random()
    val gaussianValue = random.nextGaussian()
    val randomValue = random.nextDouble()

    val personTester = NewPerson(1, 2000)
    val firstBirth = random.nextInt(35)+15
    val numOfKids = personTester.calculateNumberOfChildren(gaussianValue)

    @Test
    fun willGiveBirth() {
        if (randomValue <= 0.47) {
            assertEquals(false, personTester.willGiveBirth(randomValue))
        }
        else {
            assertEquals(true, personTester.willGiveBirth(randomValue))
        }
    }

    @Test
    fun ageOfFirstBirth() {
        assertEquals(Math.round(gaussianValue * 12 + 27).toInt(), personTester.ageOfFirstBirth(gaussianValue))
    }

    @Test
    fun calculateNumberOfChildren() {
        if (gaussianValue < -2.5 || gaussianValue > 2.5) {
            assertEquals(0, personTester.calculateNumberOfChildren(gaussianValue))
        }
        else {
            assertEquals(Math.round(gaussianValue + 2.5).toInt(), personTester.calculateNumberOfChildren(gaussianValue))
        }
    }

    @Test
    fun giveBirth() {

        if(numOfKids <= 0) {
            assertEquals("No kids will be born", personTester.giveBirth(-4, firstBirth))
        }
        else if (numOfKids > 5) {
            assertEquals("Too many kids", personTester.giveBirth(34, firstBirth))
        }
        else {
            assertEquals(numOfKids, personTester.giveBirth(numOfKids, firstBirth).size)
            for (i in 0..(numOfKids - 1)) {
                assertEquals(2, personTester.giveBirth(numOfKids, firstBirth)[i].generation)
            }
            assertEquals(firstBirth, personTester.giveBirth(numOfKids,firstBirth)[0].dateOfBirth)
            if (numOfKids == 5) {
                assertEquals(firstBirth + 8, personTester.giveBirth(numOfKids, firstBirth)[4].dateOfBirth)
            }
            for (i in 1..(numOfKids - 1)) {
                assertEquals(firstBirth + i + 2, personTester.giveBirth(numOfKids, firstBirth)[i].dateOfBirth)
            }
        }
    }

}