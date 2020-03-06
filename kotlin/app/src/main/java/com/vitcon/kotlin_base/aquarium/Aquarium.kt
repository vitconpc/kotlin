package com.vitcon.kotlin_base.aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int = width * length * height / 1000
    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        val tank = water + water * 0.1
        height = (tank / (length + width)).toInt()
    }
}

class TowerTank() : Aquarium() {
    override var water = volume * 0.8
    override var volume: Int
        get() = (width * height * height / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}