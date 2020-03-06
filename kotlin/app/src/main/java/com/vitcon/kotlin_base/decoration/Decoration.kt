package com.vitcon.kotlin_base.decoration

import android.util.Log
import com.vitcon.kotlin_base.decoration.Shape.Rectangle


// enum

enum class Color(var nameColor: String){
    RED("Màu đỏ"),
    GREEN("màu xanh lá"),
    YELLOW("màu vàng")
}

interface SpiceColor {
    val color : Color
}

class YellowSpiceColor : SpiceColor{
    override val color = Color.YELLOW
}

// sealed class

sealed class Shape{
    class Circle(var radius : Float) : Shape()
    class Square (var length: Int) : Shape()
    class Rectangle(var width : Int, var height : Int) : Shape()
}

fun caculator(shape: Shape){
    when(shape){
        is Shape.Circle -> Log.d("Fish","diện tích hình tròn là : ${3.14*shape.radius*shape.radius}")
        is Shape.Square -> Log.d("Fish"," diện tích hình vuông là : ${shape.length*shape.length}")
        is Rectangle -> Log.d("Fish","diện tích hình chữ nhật là ${shape.height*shape.width}")
    }
}

