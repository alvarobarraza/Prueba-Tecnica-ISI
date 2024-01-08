package com.example.pruebatecnica_isimo.ui.firstPoint

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.pruebatecnica_isimo.databinding.FragmentFirstPointBinding

class FirstPointFragment : Fragment() {

    private lateinit var binding: FragmentFirstPointBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPointBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

        this.binding.btnPrimo.setOnClickListener {

            val txtPrimo = binding.etTextTo.text.toString()

            if(txtPrimo.isEmpty() || txtPrimo == "" || txtPrimo.toInt() == 0){
                binding.etTextTo.error = "Digite un numero disponible"
                binding.etTextTo.requestFocus()
            }else{
                hideKeyboard()
                if (primeNumbers(txtPrimo.toInt())) {
                    binding.txtSiEsPrimoONo.text = "El Numero ${txtPrimo.toInt()} es primo"
                    binding.etTextTo.text = null
                } else {
                    binding.txtSiEsPrimoONo.text = "El Numero ${txtPrimo.toInt()} No es primo"
                    binding.etTextTo.text = null
                }
            }

        }

    }

    private fun Fragment.hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    fun primeNumbers(number: Int): Boolean {
        // Comprobar si el número es menor o igual a 1 (los números <= 1 no son primos)
        if (number <= 1) {
            return false
        }

        // Iterar desde 2 hasta (number - 1) para verificar si hay algún divisor
        for (i in 2 until number) {
            // Si el número es divisible por algún otro número en el rango, no es primo
            if (number % i == 0) {
                return false
            }
        }

        // Si no se encontró ningún divisor, el número es primo
        return true
    }


}