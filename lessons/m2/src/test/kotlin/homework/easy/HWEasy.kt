package ru.otus.otuskotlin.coroutines.homework.easy

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class HWEasy {

    @Test
    fun easyHw() {
        val numbers = generateNumbers()
        val toFind = 10
        val toFindOther = 1000

        val foundNumbers = listOf(
            findNumberInList(toFind, numbers),
            findNumberInList(toFindOther, numbers)
        )

        foundNumbers.forEach {
            if (it != -1) {
                println("Your number $it found!")
            } else {
                println("Not found number $toFind || $toFindOther")
            }
        }
    }

    @Test
    fun easyCoroutinesHw() {
        runBlocking(context = Dispatchers.Default) {
            val numbers = generateNumbers()
            val toFind = 10
            val toFindOther = 1000

            val res1 = async {
                println("[${Thread.currentThread().name}] start")
                findNumberInList(toFind, numbers)
            }
            val res2 = async {
                println("[${Thread.currentThread().name}] start")
                findNumberInList(toFindOther, numbers)
            }

            val foundNumbers = listOf(res1.await(), res2.await())

            foundNumbers.forEach {
                if (it != -1) {
                    println("Your number $it found!")
                } else {
                    println("Not found number $toFind || $toFindOther")
                }
            }
        }
    }
}