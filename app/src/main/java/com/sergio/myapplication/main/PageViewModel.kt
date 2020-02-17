package com.sergio.myapplication.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
    // Este texto aparecerá en cada TextView de cada pestaña
    val text: LiveData<String> = Transformations.map(_index) {
        "Pestaña numero  $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}