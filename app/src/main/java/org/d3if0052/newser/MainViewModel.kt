package org.d3if0052.newser

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0052.newser.db.NewsDao
import org.d3if0052.newser.model.Berita
import org.d3if0052.newser.network.BeritaApi

class MainViewModel : ViewModel() {
    private var data = MutableLiveData<ArrayList<Berita>>()
    private val status = MutableLiveData<BeritaApi.ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(BeritaApi.ApiStatus.LOADING)
            try {
                data.postValue(BeritaApi.service.getBerita())
                status.postValue(BeritaApi.ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(BeritaApi.ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<ArrayList<Berita>> = data
    fun getStatus(): LiveData<BeritaApi.ApiStatus> = status
}