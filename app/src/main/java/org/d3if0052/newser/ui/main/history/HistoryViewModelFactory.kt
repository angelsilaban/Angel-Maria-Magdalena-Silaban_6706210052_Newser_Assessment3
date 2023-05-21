package org.d3if0052.newser.ui.main.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0052.newser.db.NewsDao

class HistoryViewModelFactory( private val db: NewsDao
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
                return HistoryViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }