package com.example.pruebatecnica_isimo.ui.thirdPoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.pruebatecnica_isimo.databinding.FragmentThirdPointBinding

class ThirdPointFragment : Fragment() {

    private lateinit var binding: FragmentThirdPointBinding
    private lateinit var viewModel: ThirdPointViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdPointBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ThirdPointViewModel::class.java]

        showRecycleView()

        this.binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

    }

    private fun showRecycleView() {
        val recyclerView = binding.rvListUser
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = UserListAdapter(viewModel.getUserList())
        recyclerView.adapter = adapter
    }

}