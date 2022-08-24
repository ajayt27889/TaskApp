package com.ajay.taskapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajay.taskapp.domain.Repository
import com.ajay.taskapp.usecases.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    private var _repositoriesData = MutableLiveData<List<Repository>>()
    val repositoriesData: LiveData<List<Repository>> = _repositoriesData

    fun getRepositories() {
        viewModelScope.launch {
            _repositoriesData.value =  mainUseCase.getRepositories()
        }
    }

}