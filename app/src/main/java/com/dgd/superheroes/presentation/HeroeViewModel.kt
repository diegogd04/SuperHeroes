package com.dgd.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgd.superheroes.app.ErrorApp
import com.dgd.superheroes.data.remote.HeroeRemoteDataSource
import com.dgd.superheroes.domain.Heroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HeroeViewModel(private val heroeRemoteDataSource: HeroeRemoteDataSource) : ViewModel() {
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel

    fun loadHeroe(){
        _uiModel.value = UiModel(isLoading = true)

        viewModelScope.launch(Dispatchers.Main){
            heroeRemoteDataSource.getHeroe()
        }
    }

    data class UiModel(
        val isLoading: Boolean = false,
        val error: ErrorApp? = null,
        val heroe: Heroe? = null
    )
}