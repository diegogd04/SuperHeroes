package com.dgd.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dgd.superheroes.data.remote.HeroeRemoteDataSource
import com.dgd.superheroes.data.remote.WorkRemoteDataSource
import com.dgd.superheroes.databinding.ActivityMainBinding
import com.dgd.superheroes.domain.GetHeroeUseCase
import com.dgd.superheroes.domain.GetWorkUseCase
import com.dgd.superheroes.domain.Heroe
import com.dgd.vacio.RecyclerView.HeroeAdapter

class HeroeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val heroeAdapter = HeroeAdapter()

    private val viewModel: HeroeViewModel by lazy {
        HeroeViewModel(
            HeroeRemoteDataSource(),
            WorkRemoteDataSource(),
            GetHeroeUseCase(HeroeRemoteDataSource()),
            GetWorkUseCase(WorkRemoteDataSource())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObserver()
        viewModel.loadHeroe()
    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupView(){
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                this@HeroeActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            list.adapter = heroeAdapter
        }
    }

    private fun setupObserver(){
        val observer = Observer<HeroeViewModel.UiModel> { uiModel ->
            uiModel.heroes?.let {
                bind(it)
            }
        }
        viewModel.uiModel.observe(this, observer)
    }

    private fun bind(heroes: List<Heroe>) {
        heroeAdapter.setDataList(heroes)
    }
}