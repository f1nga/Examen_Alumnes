package com.finga.examen_alumnes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finga.examen_alumnes.ui.model.Alumne

class ListViewModel : ViewModel() {

    private val _listData = MutableLiveData<MutableList<Alumne>>()
    private var _alumne : Alumne? = null

    fun setListData(listaAlumnes: MutableList<Alumne>) {
        _listData.value = listaAlumnes
    }

    fun setAlumne(alumne: Alumne) {
        _alumne = alumne
    }

    fun getAlumne(): Alumne? {
        return _alumne
    }

    fun getListaAlumnesLiveData(): LiveData<MutableList<Alumne>> {
        return _listData
    }
}