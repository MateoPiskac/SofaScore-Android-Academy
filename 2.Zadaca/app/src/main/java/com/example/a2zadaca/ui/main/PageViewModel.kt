package com.example.a2zadaca.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.a2zadaca.InputFragment
import com.example.a2zadaca.ListFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class Person(val name: String, val surname: String, val age: String, val oib: String){
    override fun toString(): String {
        return ("$name, $surname, $age, $oib")
    }
}
open class PageViewModel : ViewModel() {
    private val peopleFlow = MutableStateFlow<List<Person>>(emptyList())

    fun addPerson(person: Person) {
        peopleFlow.value = peopleFlow.value + person
    }
    fun people(): Flow<List<Person>> = peopleFlow
}
