package com.vitcon.kotlin_base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vitcon.kotlin_base.aquarium.Plecostomus
import com.vitcon.kotlin_base.aquarium.Shark
import com.vitcon.kotlin_base.decoration.Shape
import com.vitcon.kotlin_base.decoration.caculator
import com.vitcon.myapplication.R
import kotlinx.android.synthetic.main.activity_kotlin_base.*
import java.lang.Math.random

class KotlinBaseActivity : AppCompatActivity() {

    var dirty = 20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_base)
        var text = "hello"
        val text2 = "hello"
        text_result.text = (text == text2).toString()
//        var welcomeMessage = 0
//        return when{
//            welcomeMessage == 0 ->text_result.text = "Nothing to say?"
//            text.length in 1..50 -> text_result.text = "Perfect"
//            else -> println("Too long!")
//        }

        val mylist = mutableListOf(
            "anivia",
            "annie",
            "alistar",
            "akali",
            "axtrox",
            "bard",
            "braum",
            "brand",
            "caitlyn"
        )
        var result = ""

        //duyệt mảng cùng phần tử
        for (element in mylist) {
        }

        for ((index, element) in mylist.withIndex()) {  // duyệt cùng index
            result += "$index : $element\n"
        }
        text_result.text = result

        for (i in 'a'..'g') {
        } //duyệt theo alphabest
        for (i in 1..5) {
        } // duyệt từ 1 đến 5
        for (i in 5 downTo 1) {
        } // duyệt từ 5 đến 1
        for (i in 1..15 step 2) {
        } // duyệt từ 1 đến 15 và nhảy 2 bước

        //bộ lọc
        val filterList = mylist.filter { it.contains("n") }.sortedBy { it.length }
        result = filterList.toString()
        text_result.text = result

        // lambda trong kotlin
        val waterFilter = { number: Int -> number / 2 } //lamdbda
        text_result.text = waterFilter(dirty).toString()

        dirtyProcessor()
        val day = 3
        val dow = "Thứ 2"
        showDay(day, "Thứ 2", function)

        showDay2(day, dow, ::function_2)


//        --------------------------------------------------------- abstract, interface
        val shark = Shark()
        val plecostomus = Plecostomus()
        Log.d("Fish","shark have${shark.color} color and Plecostomus have${plecostomus.color} color")

        shark.eat()
        plecostomus.eat()
//        ---------------------------------------------------- enum, sealed class
        var circle = Shape.Circle(2.0f)
        var square = Shape.Square(4)
        var rectangle = Shape.Rectangle(4,5)

        caculator(circle)
        caculator(square)
        caculator(rectangle)
    }

    fun showDay2(day: Int, dow: String, function: (Int, String) -> String) {
        text_result.text = function(day, dow)
    }

    fun showDay(day_of_month: Int, day_of_week: String, function: (Int, String) -> String) {
        text_result.text = function(day_of_month, day_of_week)
    }

    fun dirtyProcessor() {
        dirty = updateDirty(dirty, waterFilter2)
        dirty = updateDirty(dirty, ::feedFish)
        dirty = updateDirty(dirty, { dirty ->
            dirty + 50
        })
    }

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int { // hàm nâng cao trong kotlin
        return operation(dirty)
    }

    fun feedFish(dirty: Int) = dirty + 15

    val waterFilter2: (Int) -> Int = { number -> number / 2 } // lambda trong kotlin

    val random1 = random()
    val random2 = { random() }
    val operaton: (Int) -> Int = { number ->
        var x = number
        Log.d("AAA-0", x.toString())
        x += 30
        Log.d("AAA-1", x.toString())
        x -= 20
        Log.d("AAA-2", x.toString())
        x * 10
    }

    val function: (Int, String) -> String =
        { day_of_month, day_of_week -> "hôm nay là $day_of_week và là ngày $day_of_month trong tháng" }

    fun function_2(dom: Int, dow: String): String {
        return "hôm nay là $dow và là ngày mùng $dom trong tháng"
    }
}
