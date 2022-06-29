package com.nanit.kmmdemo.android.main

import androidx.lifecycle.*
import com.nanit.kmmdemo.data.network.common.NetworkClientImpl
import com.nanit.kmmdemo.data.network.features.testdata.TestNetworkDataSource
import com.nanit.kmmdemo.data.repository.testdata.TestDataRepositoryImpl
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

    // TODO move it to DI
    class Factory : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                FetchTestDataUseCase(
                    TestDataRepositoryImpl(
                        TestNetworkDataSource(
                            NetworkClientImpl()
                        )
                    )
                )
            ) as T
        }
    }
}