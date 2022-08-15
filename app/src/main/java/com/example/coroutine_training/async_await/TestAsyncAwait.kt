package com.example.coroutine_training.async_await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

//fun main() {
//    runBlocking {
////        //chay tuan tu
////       val time = measureTimeMillis {
////           val a = funny1()
////           val b = funny2()
////           println(a+b)
////       }
//        //chay song song
//        val time = measureTimeMillis {
//            try {
//                val a: Deferred<Int> = async { funny1() }
//                val b: Deferred<Int> = async { funny2() }
//                println(a.await() + b.await())
//            }finally {
//               println("hello")
//            }
//        }
//        println(time)
//    }
//
//}
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("in $i ...")
                delay(500L)
            }
        } finally {
            println("finally")
//            delay(1000L)
            println("Đố mà in được!")
        }
    }
    delay(1300L) // delay a bit
    println("main: Đừng in nữa t mệt rồi!")
    job.cancel() // cancels the job
    println("main:Hoan thành.")
}

suspend fun funny1(): Int {
    delay(1000)
    return 0
}

suspend fun funny2(): Int {
    delay(1000)
    return 2
}