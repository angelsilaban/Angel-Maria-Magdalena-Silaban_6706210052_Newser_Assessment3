package org.d3if0052.newser.requestberita

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0052.newser.db.News
import org.d3if0052.newser.db.NewsDao


class RequestBeritaViewModel(private val db: NewsDao) : ViewModel() {
    private val newsLiveData = MutableLiveData<News?>()

    fun getData(judul: String) {
        val dataNews = News(judul = judul)
        newsLiveData.value = dataNews

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataNews)
            }
        }
    }

    fun getHasilNews(): LiveData<News?> = newsLiveData
}

class RequestBeritaViewModelFactory(
    private val db: NewsDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RequestBeritaViewModel::class.java)) {
            return RequestBeritaViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") }
}