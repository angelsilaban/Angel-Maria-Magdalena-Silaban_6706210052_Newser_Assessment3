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
        newsLiveData.value = dataNews.ambilData()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataNews)
            }
        }
    }

    fun News.ambilData() : News{
        val id = id
        val tanggal = tanggal
        val judul = judul
        return News(id, tanggal,judul)
    }

    fun getHasilNews(): LiveData<News?> = newsLiveData
}