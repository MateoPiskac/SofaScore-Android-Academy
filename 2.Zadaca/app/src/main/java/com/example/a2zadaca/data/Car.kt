package com.example.a2zadaca.data

data class Car(
    val manufacturer: String,
    val model: String,
    val age: String,
    val enginePower: String,
    val cylinders: Int,
    val engineType: EngineType
) {
    override fun toString(): String {
        return ("$manufacturer, $model, $age, $enginePower HP, $cylinders cylinders $engineType")
    }
}