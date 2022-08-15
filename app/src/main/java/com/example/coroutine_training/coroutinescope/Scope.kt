package com.example.coroutine_training.coroutinescope

import kotlinx.coroutines.*
import org.junit.After
import org.junit.Before
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

fun main() {

    val job = CoroutineScope(Dispatchers.IO).launch {
        try {
            println("start" + System.currentTimeMillis())
            launch {
                delay(1000L)
            }
        } finally {
            println("hoan thanh  ${Thread.currentThread().name}")
        }
    }
    Thread.sleep(5000L)
  job.cancel()
    //part 2
//    val job = MyScope().launch {
//        println(Thread.currentThread().name)
//    }
}

private suspend fun a(): Int {
    delay(500L)
    return 10
}

private suspend fun b(): Int {
    delay(500L)
    return 10
}

class MyScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined
}
