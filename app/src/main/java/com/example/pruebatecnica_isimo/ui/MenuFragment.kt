package com.example.pruebatecnica_isimo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebatecnica_isimo.R
import com.example.pruebatecnica_isimo.databinding.FragmentMenuBinding
import com.example.pruebatecnica_isimo.ui.firstPoint.FirstPointFragment
import com.example.pruebatecnica_isimo.ui.fourthPoint.FourthPointFragment
import com.example.pruebatecnica_isimo.ui.secondPoint.SecondPointFragment
import com.example.pruebatecnica_isimo.ui.thirdPoint.ThirdPointFragment

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btn1.setOnClickListener {
            navigateToFragment(FirstPointFragment())
        }

        this.binding.btn2.setOnClickListener{
            navigateToFragment(SecondPointFragment())
        }

        this.binding.btn3.setOnClickListener {
            navigateToFragment(ThirdPointFragment())
        }

        this.binding.btn4.setOnClickListener{
            navigateToFragment(FourthPointFragment())
        }

    }

    private fun navigateToFragment(fragment: Fragment) {

        val transaction = fragmentManager?.beginTransaction()

        transaction?.setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )

        transaction?.replace(R.id.nav_host_fragment, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

}