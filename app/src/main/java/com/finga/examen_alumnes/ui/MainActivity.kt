package com.finga.examen_alumnes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finga.examen_alumnes.R
import com.finga.examen_alumnes.databinding.ActivityCreateAlumnBinding
import com.finga.examen_alumnes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            val intent = Intent(this, CreateAlumnActivity::class.java)
            startActivity(intent)
        }


    }
}