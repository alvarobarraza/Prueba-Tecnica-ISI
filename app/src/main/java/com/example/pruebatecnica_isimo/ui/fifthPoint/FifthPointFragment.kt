package com.example.pruebatecnica_isimo.ui.fifthPoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebatecnica_isimo.R
import com.example.pruebatecnica_isimo.databinding.FragmentFifthPointBinding
import com.example.pruebatecnica_isimo.databinding.FragmentFirstPointBinding

class FifthPointFragment : Fragment() {

    private lateinit var binding: FragmentFifthPointBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthPointBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

    }

}