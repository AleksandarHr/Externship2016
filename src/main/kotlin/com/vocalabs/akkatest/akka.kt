package com.vocalabs.akkatest

import akka.actor.ActorSystem
/*
import akka.actor.Props
import akka.actor.UntypedActor
import akka.actor.UntypedActorContext
import akka.actor.ActorPath
import akka.actor.ActorSystem
import akka.actor.ActorRef
*/
import com.vocalabs.util.pmap

/**
 * This is the main function that gets run when we run the JAR file.
 */
fun main(args: Array<String>) {
    System.out.println("Hello!")
    System.out.println("hflkjhflkgjdahglka")

    for (arg in args) {
        System.out.println(hi(arg))
    }

    val results = (1..1000).pmap { x ->
        val y = Math.sqrt(x*100.0)*(x*99.0)
        "$x -> $y"
    }
    println(results)

    System.out.println("ActorSystem home: "+ActorSystem.SystemHome())
}

private fun hi(s: String) = "Hello, $s"