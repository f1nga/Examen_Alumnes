package com.finga.examen_alumnes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.databinding.FragmentAlumneInfoBinding
import com.finga.examen_alumnes.viewmodel.ListViewModel


class AlumneInfoFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAlumneInfoBinding>(
            inflater,
            R.layout.fragment_alumne_info, container, false
        )

        binding.txtNom.text = viewModel.getAlumne()?.nom
        binding.txtEdat.text = viewModel.getAlumne()?.edat.toString()

        return binding.root
    }

}