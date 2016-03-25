package com.vocalabs.util

import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Based on http://stackoverflow.com/questions/34697828/parallel-operations-on-kotlin-collections#34699904
 */
fun <T, R> Iterable<T>.pmap(
        numThreads: Int = Runtime.getRuntime().availableProcessors(),
        exec: ExecutorService = Executors.newFixedThreadPool(numThreads),
        transform: (T) -> R): List<R> {

    // default size is just an inlined version of kotlin.collections.collectionSizeOrDefault
    val destination = ArrayList<R>(if (this is Collection<*>) this.size else 10)

    for (item in this) {
        exec.submit {
            val transformed = transform(item)
            synchronized(destination) {
                destination.add(transformed)
            }
        }
    }

    exec.shutdown()
    exec.awaitTermination(1, TimeUnit.DAYS)

    return destination
}

fun histogram(items: Iterable<Int>): String {
    val map = TreeMap<Int,Int>()
    for (item in items) {
        val oldCount = map.get(item)
        val count = if (oldCount == null) 1 else 1+oldCount
        map.put(item, count)
    }

    val result = StringBuilder()
    for (pair in map) {
        result.append("${pair.key} ")
        for (num in 1..pair.value) {
            result.append("#")
        }
        result.append("\n")
    }
    return result.toString()
}