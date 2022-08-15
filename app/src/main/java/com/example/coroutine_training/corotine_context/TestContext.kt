package com.example.coroutine_training.corotine_context

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    runBlocking {
        val block1 = launch(newSingleThreadContext("Mit")) {
            delay(100L)
            println(Thread.currentThread().name)
            launch(Dispatchers.IO) {
                delay(100L)
                println(Thread.currentThread().name)
            }
            launch(newSingleThreadContext("Chinh")) {
                delay(100L)
                println(Thread.currentThread().name)
            }
            withContext(Dispatchers.Unconfined) {
                delay(100L)
                println(Thread.currentThread().name)
            }
        }
        val block2 = launch {
            block1.join()
            delay(100L)
            println("block 2")
        }
    }
    Thread.sleep(1500L)
}