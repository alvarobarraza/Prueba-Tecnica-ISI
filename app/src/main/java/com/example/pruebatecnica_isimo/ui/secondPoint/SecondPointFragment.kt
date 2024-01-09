package com.example.pruebatecnica_isimo.ui.secondPoint

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.pruebatecnica_isimo.databinding.FragmentSecondPointBinding

class SecondPointFragment : Fragment() {

    private lateinit var binding: FragmentSecondPointBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondPointBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnToast.setOnClickListener{

            val textToast = binding.etTextTo.text.toString()

            if(textToast.isEmpty() || textToast == ""){
                binding.etTextTo.error = "Digite un texto"
                binding.etTextTo.requestFocus()
            }else{
                hideKeyboard()
                Toast.makeText(requireContext(), "Digitaste: $textToast",Toast.LENGTH_LONG).show()
                binding.etTextTo.text = null
            }
        }

        this.binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

    }

    private fun Fragment.hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}