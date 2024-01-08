package com.example.pruebatecnica_isimo.ui.fourthPoint

import Character
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica_isimo.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(private val listCharacter: List<Character>):
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val user = listCharacter[position]
        holder.binding.userNameTextView.text = user.name
        Picasso.get().load(user.image).into(holder.binding.userImageView)
        //holder.binding.userImageView.setImageURI(user.image)
    }

}