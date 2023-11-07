package com.dgd.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgd.superheroes.app.ErrorApp
import com.dgd.superheroes.data.remote.HeroeRemoteDataSource
import com.dgd.superheroes.data.remote.WorkRemoteDataSource
import com.dgd.superheroes.domain.GetHeroeUseCase
import com.dgd.superheroes.domain.GetWorkUseCase
import com.dgd.superheroes.domain.Heroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroeViewModel(
    private val heroeRemoteDataSource: HeroeRemoteDataSource,
    private val workRemoteDataSource: WorkRemoteDataSource,
    private val getHeroeUseCase: GetHeroeUseCase,
    private val getWorkUseCase: GetWorkUseCase
) : ViewModel() {
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel

    fun loadHeroe(){
        _uiModel.value = UiModel(isLoading = true)

        viewModelScope.launch(Dispatchers.IO){

            getHeroeUseCase().fold(
                {responseError(it)},
                {responseSuccess(it)}
            )

        }
    }

    private fun responseError(error: ErrorApp){
        _uiModel.postValue(UiModel(error = error))
    }

    private fun responseSuccess(heroes: List<Heroe>){
        _uiModel.postValue(UiModel(heroes = heroes))
    }

    data class UiModel(
        val isLoading: Boolean = false,
        val error: ErrorApp? = null,
        val heroes: List<Heroe>? = null
    )
}