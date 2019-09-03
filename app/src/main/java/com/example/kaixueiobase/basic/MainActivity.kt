package com.example.kaixueiobase.basic

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kaixueiobase.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * https://kaixue.io/kotlin-basic-1/
 * 思考题：
 * 1. 子类重写父类的 override 函数，能否修改它的可见性？
 * 2. 以下的写法有什么区别？
 *      activity as? NewActivity
 *      activity as NewActivity?
 *      activity as? NewActivity?
 *
 * 练习题：
 * 1. 使用 Android Studio 创建一个基于 Kotlin 的新项目（Empty Activity），
 *    添加一个新的属性（类型是非空的 View），在 onCreate 函数中初始化它。
 * 2. 声明一个参数为 View? 类型的方法，传入刚才的 View 类型属性，
 *    并在该方法中打印出该 View? 的 id。
 */

class MainActivity : AppCompatActivity() {

    private lateinit var mTvHi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvHi = tv_hi
        printId(mTvHi)
        think(this)
    }

    private fun printId(v: View?) = print(v?.id)

    private fun think(activity: AppCompatActivity?) {
        activity as? MainActivity // -> 可转则转，不可转，则不作处理（默认catch空指针异常）
        activity as MainActivity? // -> 转的目标为，MainActivity?
        activity as? MainActivity? // -> 在2的基础上，不可转不作处理
    }

    /*
    可以修改父类的访问权限，但是只能增大，不能减小
    override fun onStart() {
        super.onStart()
    }

    public override fun onStop() {
        super.onStop()
    }

    // error
    private override fun onResume() {
        super.onResume()
    }
     */
}

