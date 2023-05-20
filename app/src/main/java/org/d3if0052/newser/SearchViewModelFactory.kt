package org.d3if0052.newser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0052.newser.db.dao.NewsDao

class SearchViewModelFactory (
    private val db: NewsDao
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
                return SearchViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
