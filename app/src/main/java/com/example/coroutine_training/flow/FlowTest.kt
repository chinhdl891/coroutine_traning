package com.example.coroutine_training.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun foo(x: Int): Flow<Int> = flow {
    for (i in 0..x) {
        Thread.sleep(1000)
        println("Emitting $i")
        emit(i)
    }
}


fun main() {
    // Collect the flow
//    val a = withTimeout(10000) {
//        foo(5).collect { value -> println(value) }
//    }
//    println("done")
//    flowOf().collect {
//        println(it)
//    }
//    (0..5).asFlow().collect{println(it)}
    val list = listOf<Int>(1, 3, 5, 7, 9, 11, 13)
    //transform
//    list.asFlow().transform { emit(5 + it) }.collect { println(it) }
    //map
//    list.asFlow().map {
//        it * it
//    }.collect { println(it) }
    //take
//    list.asFlow().take(2).collect{ println(it)}
    //filter
//    list.asFlow().filterNot { it%2==0 }.collect{ println(it)}
    //reduce
//   val sum = list.asFlow().reduce{accumulator, value ->
//        accumulator + value
//    }
//    println(sum)
//    val sum = list.asFlow().fold(5){accumulator, value ->
//        accumulator + value
//    }
//    println(sum)
//    val sum = list.asFlow().filter { it % 2 == 1 }.map { it + 1 }.transform {
//        emit(it + 5)
//
//        emit(it + 10)
//    }.fold(5) { accumulator, value -> accumulator + value }
//    println(sum)
//    runBlocking {
//    println(listOf(10).asFlow().single())
//    }
    val numChan = listOf<Int>(2, 4, 6, 8).asFlow().onEach { delay(500) }
    val numLe = listOf<Int>(3, 5, 7, 9).asFlow().onEach { delay(100) }
    runBlocking {
//        val time = measureTimeMillis {
//            numChan.zip(numLe) { i: Int, i2: Int -> "so thu nhat $i and so thu hai $i2 " }
//                .collect { println(it) }
//        }
//        println(time)
//        val time2 = measureTimeMillis {
//            numChan.combine(numLe) { i: Int, i2: Int -> "so thu nhat $i and so thu hai $i2 " }
//                .collect { println(it) }
//        }
//        println(time2)

    }

}

fun flowOf(): Flow<Int> = flow {
    for (i in 0..50) {
        if (i == 30) {
            continue
        }
        emit(i)
    }
}

