package com.example.coroutine_training

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            val startTime = System.currentTimeMillis()
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("Default : Đang in ${i++} ...")
                    nextPrintTime += 500
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: Đừng in nữa t mệt rồi!")
        job.cancel() // cancels the job
        println("main: Hoàn thành.")
    }
    //isActive
//    runBlocking {
//        val job = launch(Dispatchers.Default) {
//            val startTime = System.currentTimeMillis()
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive) {
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    println("Default : Đang in ${i++} ...")
//                    nextPrintTime += 500
//                }
//            }
//        }
//        delay(1300L) // delay a bit
//        println("main: Đừng in nữa t mệt rồi!")
//        job.cancel() // cancels the job
//        println("main: Hoàn thành.")
//    }
}