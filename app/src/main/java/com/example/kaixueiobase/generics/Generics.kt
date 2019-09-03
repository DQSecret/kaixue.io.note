package com.example.kaixueiobase.generics

import androidx.annotation.Size

/**
 * 练习题：
 * 1. 实现一个 fill 函数，传入一个 Array 和一个对象，将对象填充到 Array 中，
 *      要求 Array 参数的泛型支持逆变（假设 Array size 为 1）。
 * 2. 实现一个 copy 函数，传入两个 Array 参数，将一个 Array 中的元素复制到另外个 Array 中，
 *      要求 Array 参数的泛型分别支持协变和逆变。
 *      （提示：Kotlin 中的 for 循环如果要用索引，需要使用 Array.indices）
 */

open class GenericsSuper

open class Generics : GenericsSuper()
open class GenericsSub : Generics()

fun <T> fill(@Size(1) arr: Array<in T>, item: T) {
    arr[0] = item
}

fun <T> copy(@Size(min = 1) src: Array<in T>, @Size(min = 1) dest: Array<out T>) {
    src.indices.forEach { src[it] = dest[it] }
}

fun main() {
    val arr = Array(1) { GenericsSuper() }
    val item = GenericsSub()
    fill<GenericsSub>(arr, item)

    val arr1 = Array(1) { GenericsSuper() }
    val arr2 = Array(1) { GenericsSub() }
    copy<Generics>(arr1, arr2)
}