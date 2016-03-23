package com.vocalabs.age

import java.util.*

/**
 * Created by Aleksandar on 23.3.2016 г..
 */

class NumberOfChildren {

     fun calculateNumberOfChildren(): Int {
         var random = Random()
         var numOfChildren = 0
         var gaussian = random.nextGaussian() * 1 + 2.5
              if (gaussian >= 0.0 && gaussian <= 5.0) {
                 numOfChildren = Math.round(gaussian).toInt()
              }
          return numOfChildren
    }
}
