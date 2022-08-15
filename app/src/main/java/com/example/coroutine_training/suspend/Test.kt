package com.example.coroutine_training.suspend

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        test()
    }
}

suspend fun test() {
    val start = System.currentTimeMillis()
    delay(1000)
    val end = System.currentTimeMillis() - start
    println(end)
}