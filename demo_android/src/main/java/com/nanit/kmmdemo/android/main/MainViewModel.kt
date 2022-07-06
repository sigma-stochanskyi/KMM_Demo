package com.nanit.kmmdemo.android.main

import androidx.lifecycle.*
import com.nanit.kmmdemo.domain.FetchTestDataUseCase
import com.nanit.test.data.db.features.testdata.TestLocalDataSource2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchTestDataUseCase: FetchTestDataUseCase,
    private val testLocalDataSource2: TestLocalDataSource2
) : ViewModel() {

    private val _titleLiveData = MutableLiveData<String>()
    val titleLiveData: LiveData<String> = _titleLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _titleLiveData.postValue(fetchTestDataUseCase.invoke().title)
            val result = testLocalDataSource2.getFirstData()?.title ?: ""
        }
    }
}