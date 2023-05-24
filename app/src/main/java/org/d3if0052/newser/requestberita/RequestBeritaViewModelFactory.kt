package org.d3if0052.newser.requestberita

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0052.newser.db.NewsDao

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