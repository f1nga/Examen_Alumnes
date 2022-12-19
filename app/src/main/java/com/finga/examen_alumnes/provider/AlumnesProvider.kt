package com.finga.examen_alumnes.provider

import com.finga.examen_alumnes.ui.model.Alumne

class AlumnesProvider {
    private var llistaAlumnes : MutableList<Alumne> = mutableListOf()

    fun getListaAlumnes(): MutableList<Alumne> {
        return llistaAlumnes
    }

    fun addAlumne(alumne: Alumne) {
        llistaAlumnes.add(alumne)
    }
}