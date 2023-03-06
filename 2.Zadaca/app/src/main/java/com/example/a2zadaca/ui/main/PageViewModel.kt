package com.example.a2zadaca.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2zadaca.InputFragment
import com.example.a2zadaca.ListFragment

data class Person(val name: String, val surname: String, val age: String, val oib: String){
    override fun toString(): String {
        return ("$name, $surname, $age, $oib")
    }
}
open class PageViewModel : ViewModel() {
    var currentTab = 0
    private val people = mutableListOf<Person>()
    private val _dataItemListLiveData = MutableLiveData<List<Person>>()
    val dataItemListLiveData: LiveData<List<Person>>
        get() = _dataItemListLiveData

    fun init() {
        val dataItems = mutableListOf<Person>()
        for (i in 0 until people.size) {
            dataItems.add(people[i])
        }
        _dataItemListLiveData.value = people
    }
    fun getTabFragment(): Fragment {
        return when (currentTab) {
            0 -> InputFragment()
            1 -> ListFragment()
            else -> InputFragment()
        }
    }

    fun addPerson(person: Person) {
        people.add(person)
        _dataItemListLiveData.value = people
    }

    fun getPeople(): List<Person> {
        return people.toList()
    }

    fun clearPeople() {
        people.clear()
        _dataItemListLiveData.value = people
    }
}
