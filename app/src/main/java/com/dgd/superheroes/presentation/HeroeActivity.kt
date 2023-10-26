package com.dgd.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dgd.superheroes.R
import com.dgd.superheroes.data.remote.HeroeRemoteDataSource
import com.dgd.superheroes.domain.Heroe

class HeroeActivity : AppCompatActivity() {

    private val viewModel: HeroeViewModel by lazy {
        HeroeViewModel(
            HeroeRemoteDataSource()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadHeroe()
    }
}