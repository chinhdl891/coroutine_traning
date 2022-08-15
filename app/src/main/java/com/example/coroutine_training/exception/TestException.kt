package com.example.coroutine_training.exception

import kotlinx.coroutines.*

import kotlin.coroutines.CoroutineContext

fun main() {
//    runBlocking {
//        val job = GlobalScope.launch {
//            try {
//                println("Throw exception from launch")
//                throw NullPointerException()
//            } catch (e: Exception) {
//                println(e)
//            }
//        }
//        job.join()
//        val deferred = GlobalScope.async {
//            try {
//                println("Throw exception from async")
//                throw IndexOutOfBoundsException()
//            } catch (e: Exception) {
//                println(e)
//            }
//        }
//        deferred.await()
//    }
//    runBlocking {
//        val handle = CoroutineExceptionHandler {_, throwable -> println(throwable)}
//        val job = MyThread(Dispatchers.Unconfined).launch(handle) {
//            println("${Thread.currentThread().name}")
//            throw AssertionError()
//        }
//        val deferred = MyThread(Dispatchers.Unconfined).async(handle) {
//            println("${Thread.currentThread().name}")
//            throw ArithmeticException() // Nothing will be printed, relying on user to call deferred.await()
//        }
//        joinAll(job, deferred)
//    }

    // set context khi sử dụng runBlocking { } để start coroutine
//    runBlocking(Dispatchers.IO + Job()) {
//
//    }

// hoặc set context khi sử dụng launch { } để start coroutine
//    runBlocking {
//        val handle = CoroutineExceptionHandler { coroutineContext, throwable -> println(throwable) }
//        val supervisor = SupervisorJob()
//        println(Thread.currentThread().name)
//        launch(handler + Dispatchers.IO) {
//            println(Thread.currentThread().name)
//            throw  IndexOutOfBoundsException()
//        }
//    }
}

//
//fun main(){
//    runBlocking {
//        val job = GlobalScope.launch(handler + Dispatchers.Unconfined) {
//                println("Throw exception from launch")
//                throw NullPointerException()
//        }
//
//        val deferred = GlobalScope.async(handler + Dispatchers.Unconfined) {
//                println("Throw exception from async")
//                throw IndexOutOfBoundsException()
//        }
//
//    }
//}
//fun main() = runBlocking {
//    val supervisor = SupervisorJob()
//    with(CoroutineScope(coroutineContext + supervisor)) {
//        // launch the first child -- its exception is ignored for this example (don't do this in practice!)
//        val firstChild = launch(CoroutineExceptionHandler { _, _ ->  }) {
//            println("First child is failing")
//            throw AssertionError("First child is cancelled")
//        }
//        // launch the second child
//        val secondChild = launch {
////            firstChild.join()
//            // Cancellation of the first child is not propagated to the second child
//            println("First child is cancelled: ${firstChild.isCancelled}, but second one is still active")
//            try {
//                delay(Long.MAX_VALUE)
//            } finally {
//                // But cancellation of the supervisor is propagated
//                println("Second child is cancelled because supervisor is cancelled")
//            }
//        }
//        // wait until the first child fails & completes
//        firstChild.join()
//        println("Cancelling supervisor")
//        supervisor.cancel()
//        secondChild.join()
//    }
//}
//fun main() {
//    runBlocking {
//        val handler = CoroutineExceptionHandler { _, exception ->
//            println(exception)
//        }
//    val job = GlobalScope.launch{
//            val first = launch(handler) {
//                println("Child throws an exception")
//                throw AssertionError()
//            }
//            val second = launch {
//                delay(500L)
//                println("Child Child")
//            }
//        }
//        job.join()
//        println("hoan thanh")
//    }
//}
public class MyThread(override val coroutineContext: CoroutineContext) : CoroutineScope
//fun main() = runBlocking<Unit> {
//    println("A context with name: ${coroutineContext + CoroutineName("test")}")
//}
