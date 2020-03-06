package com.vitcon.kotlin_base.aquarium

import android.util.Log

abstract class AquariumFish{
    abstract val color: String
}

class  Shark() : AquariumFish(), FishAction{
    override val color: String = " gray"
    override fun eat() {
        Log.d("Fish","shark hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction{
    override val color: String = " gold"
    override fun eat() {
        Log.d("Fish","plecostomus munch on algae")
    }
}

interface FishAction{
    fun eat()
}