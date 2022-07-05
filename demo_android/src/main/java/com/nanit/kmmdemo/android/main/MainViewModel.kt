package com.nanit.kmmdemo.android.main

import androidx.lifecycle.*
import com.nanit.kmmdemo.domain.FetchTestDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchTestDataUseCase: FetchTestDataUseCase
) : ViewModel() {

    private val _titleLiveData = MutableLiveData<String>()
    val titleLiveData: LiveData<String> = _titleLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _titleLiveData.postValue(fetchTestDataUseCase.invoke().title)
        }
    }
}