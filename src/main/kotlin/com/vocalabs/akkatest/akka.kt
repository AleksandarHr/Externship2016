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

/**
 * This is the main function that gets run when we run the JAR file.
 */
fun main(args: Array<String>) {
    System.out.println("Hello!")

    for (arg in args) {
        System.out.println(hi(arg))
    }

    System.out.println("ActorSystem home: "+ActorSystem.SystemHome())
}

private fun hi(s: String) = "Hello, $s"