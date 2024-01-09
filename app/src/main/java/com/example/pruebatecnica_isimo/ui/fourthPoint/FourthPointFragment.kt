package com.example.pruebatecnica_isimo.ui.fourthPoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica_isimo.R
import com.example.pruebatecnica_isimo.data.ApiRepository
import com.example.pruebatecnica_isimo.databinding.FragmentFourthPointBinding
import com.example.pruebatecnica_isimo.databinding.FragmentThirdPointBinding
import com.example.pruebatecnica_isimo.ui.thirdPoint.UserListAdapter

class FourthPointFragment : Fragment() {

    private lateinit var binding: FragmentFourthPointBinding
    private lateinit var viewModel: FourthPointViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize viewModel
        val apiRepository = ApiRepository()
        viewModel = ViewModelProvider(this, FourthPointViewModelFactory(apiRepository))[FourthPointViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthPointBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            val recyclerView = binding.rvListCharacter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            val adapter = CharacterAdapter(characters)
            recyclerView.adapter = adapter
        }

        this.binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

        viewModel.fetchCharactersInParallel()

    }

}