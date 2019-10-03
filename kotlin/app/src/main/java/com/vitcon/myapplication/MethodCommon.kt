package com.vitcon.myapplication

import android.content.Context
import android.widget.Toast

class MethodCommon {
    companion object{
        fun demo(context: Context){
            Toast.makeText(context,"hihi",Toast.LENGTH_SHORT).show()
        }
    }
}