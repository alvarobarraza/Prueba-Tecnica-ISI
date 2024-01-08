package com.example.pruebatecnica_isimo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebatecnica_isimo.R
import com.example.pruebatecnica_isimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, MenuFragment()).commit()
        }
    }
}