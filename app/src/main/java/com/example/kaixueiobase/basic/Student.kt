package com.example.kaixueiobase.basic

/**
 * 思考题：
 * 1. 关于为什么数组的 filter 之后变成 List ？
 *
 * 练习题：
 * 1. 请按照以下要求实现一个 Student 类：
 *      · 写出三个构造器，其中一个必须是主构造器
 *      · 主构造器中的参数作为属性
 * 2. 写一个普通函数 show，要求通过字符串模板输出类中的属性
 *      · 编写程序，使用今天所讲的操作符，找出集合 {21, 40, 11, 33, 78} 中能够被 3 整除的所有元素，并输出。
 */

data class Student(val name: String) {

    private var age: Int = 0
    private var gender: Int = 1 // 1男2女

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    constructor(name: String, age: Int, gender: Int) : this(name, age) {
        this.gender = gender
    }

    private fun genderFormat() = if (gender == 1) "男" else "女"

    override fun toString(): String {
        return "Student(name='$name', age=$age, gender='${genderFormat()}')"
    }

    fun show() {
        val arr = intArrayOf(21, 40, 11, 33, 78)
        val list = arr.filter { it % 3 == 0 }
        println("${arr.contentToString()} 中能被3整除的元素集合为: $list")
    }
}

fun main() {
    val s = Student("DQ", 24, 1)
    s.show()
    println(s)
}