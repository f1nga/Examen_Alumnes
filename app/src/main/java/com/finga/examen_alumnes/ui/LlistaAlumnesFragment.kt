package com.finga.examen_alumnes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.databinding.FragmentCreateAlumnBinding
import com.finga.examen_alumnes.databinding.FragmentLlistaAlumnesBinding
import com.finga.examen_alumnes.ui.adapters.ListAlumnAdapter
import com.finga.examen_alumnes.ui.model.Alumne
import com.finga.examen_alumnes.viewmodel.ListViewModel

class LlistaAlumnesFragment : Fragment() {
    private val viewModel: ListViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var listAlumnAdapter: ListAlumnAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLlistaAlumnesBinding>(
            inflater,
            R.layout.fragment_llista_alumnes, container, false
        )

        recyclerView = binding.RecyclerView


        val alumnesObserver = Observer<MutableList<Alumne>>{
            Log.i("LLISTA", it.toString())

            listAlumnAdapter = ListAlumnAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = listAlumnAdapter

            listAlumnAdapter.setOnItemClickListener(object: ListAlumnAdapter.onItemClickListener{
                override fun onItemClick(alumne: Alumne) {
                    viewModel.setAlumne(alumne)
                    view?.findNavController()?.navigate(R.id.action_llistaAlumnesFragment_to_alumneInfoFragment)
                }
            })
        }

        viewModel.getListaAlumnesLiveData().observe(viewLifecycleOwner, alumnesObserver)



        return binding.root

    }
}