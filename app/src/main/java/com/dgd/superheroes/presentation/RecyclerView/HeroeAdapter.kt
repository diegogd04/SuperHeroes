package com.dgd.vacio.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dgd.superheroes.R
import com.dgd.superheroes.domain.Heroe
import com.dgd.vacio.RecyclerView.HeroeViewHolder

class HeroeAdapter : RecyclerView.Adapter<HeroeViewHolder>() {

    private val dataList: MutableList<Heroe> = mutableListOf()

    fun setDataList(heroes: List<Heroe>){
        dataList.clear()
        addDataList(heroes)
    }

    fun addDataList(heroes: List<Heroe>){
        dataList.addAll(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_heroe_item, parent, false)
        return HeroeViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }
}