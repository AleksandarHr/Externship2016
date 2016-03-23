package com.vocalabs.age

import java.util.*

/**
 * Created by Aleksandar on 23.3.2016 г..
 */

class NumberOfChildren {
    var random = Random()
    var numOfChildren = IntArray(10)
    fun calculateNumberOfChildren() {
        var index = 0
        var gaussian: Double
        for (i in 1..10) {
            gaussian = random.nextGaussian() * 1 + 2.5
            println(gaussian)
            if (gaussian >= 0.0 && gaussian <= 0.5) {
                numOfChildren[index] = Math.round(gaussian).toInt()
                index++
            }
        }
    }
}
