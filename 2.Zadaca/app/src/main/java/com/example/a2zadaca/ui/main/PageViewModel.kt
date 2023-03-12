package com.example.a2zadaca.ui.main

import androidx.lifecycle.ViewModel
import com.example.a2zadaca.data.Car
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

open class PageViewModel : ViewModel() {
    private val carFlow = MutableStateFlow<List<Car>>(emptyList())

    fun addCar(car: Car) {
        carFlow.value = carFlow.value + car
    }
    fun cars(): Flow<List<Car>> = carFlow
}
