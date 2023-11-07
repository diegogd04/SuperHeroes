package com.dgd.vacio.RecyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dgd.superheroes.app.extensions.setUrl
import com.dgd.superheroes.databinding.ViewHeroeItemBinding
import com.dgd.superheroes.domain.Heroe

class HeroeViewHolder(val view: View): RecyclerView.ViewHolder(view){

    private lateinit var binding: ViewHeroeItemBinding

    fun bind(model: Heroe){
        binding = ViewHeroeItemBinding.bind(view)

        binding.apply {
            name.text = model.name
            image.setUrl(model.images.sm)
        }
    }

}