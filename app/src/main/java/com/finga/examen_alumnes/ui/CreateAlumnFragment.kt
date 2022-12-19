package com.finga.examen_alumnes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.databinding.FragmentCreateAlumnBinding
import com.finga.examen_alumnes.provider.AlumnesProvider
import com.finga.examen_alumnes.ui.model.Alumne
import com.finga.examen_alumnes.viewmodel.ListViewModel

class CreateAlumnFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateAlumnBinding>(
            inflater,
            R.layout.fragment_create_alumn, container, false
        )

        var listAlumnes = AlumnesProvider()

        binding.btnAfegir.setOnClickListener() {

            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Estàs segur que vols crear l'usuari?")
                .setCancelable(false)
                .setPositiveButton("Sí") { _, _ ->

                    var informeAlumne = if (binding.inputDescripcioText.text.toString() != "")  binding.inputDescripcioText.text.toString() else "Descripció"
                    var codiPostalAlumne = if (binding.inputCodiText.text.toString() != "")  binding.inputCodiText.text.toString() else "0000"

                    var alumne = Alumne(
                        binding.inputNomText.text.toString(),
                        binding.inputEdatText.text.toString().toInt(),
                        codiPostalAlumne.toInt(),
                        informeAlumne
                    )

                    listAlumnes.addAlumne(alumne)

                    viewModel.setListData(listAlumnes.getListaAlumnes())
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }

            val alert = builder.create()
            alert.show()
        }

        binding.btnLlistar.setOnClickListener() {
            it.findNavController().navigate(R.id.action_createAlumnFragment_to_llistaAlumnesFragment)
        }


        return binding.root
    }

}