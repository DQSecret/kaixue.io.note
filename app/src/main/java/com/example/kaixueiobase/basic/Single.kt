package com.example.kaixueiobase.basic

import kotlin.system.measureTimeMillis

/**
 * https://kaixue.io/kotlin-basic-2/
 * 1. 创建一个 Kotlin 类，这个类需要禁止外部通过构造器创建实例，
 *    并提供至少一种实例化方式。
 *
 * 2. 分别用 Array、IntArray、List 实现 「保存 1-100_000 的数字，
 *    并求出这些数字的平均值」，打印出这三种数据结构的执行时间。
 */

class Single private constructor() {

    companion object {
        fun getInstance(): Single = SingleHolder.instance
    }

    private object SingleHolder {
        val instance by lazy { Single() }

    }

    fun test() {
        val array = Array(100_000) { it + 1 }
        val intArray = IntArray(100_000) { it + 1 }
        val intList = List(100_000) { it + 1 }
        getTime("Array<Int>") { array.average() }
        getTime("IntArray") { intArray.average() }
        getTime("List<Int>") { intList.average() }
    }

    private fun getTime(type: String, block: () -> Double) {
        var average = 0.00
        val time = measureTimeMillis {
            average = block()
        }
        println("$type : average=$average, time=$time")
    }
}

fun main() {
    Single.getInstance().test()
}