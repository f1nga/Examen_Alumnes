package com.finga.examen_alumnes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.databinding.ActivityCreateAlumnBinding
import com.finga.examen_alumnes.provider.AlumnesProvider
import com.finga.examen_alumnes.ui.model.Alumne
import com.finga.examen_alumnes.viewmodel.ListViewModel


class CreateAlumnActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityCreateAlumnBinding>(this, R.layout.activity_create_alumn)
        val navController = this.findNavController(R.id.myNavHostFragment)

        drawerLayout = binding.drawerLayout

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
    }
}