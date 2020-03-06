package com.vitcon.kotlin_base.aquarium

class Fish (val friendly : Boolean = true, volumeNeeded: Int){
    val size : Int
    init {
        if (friendly) size = volumeNeeded else size = volumeNeeded * 2
    }
}