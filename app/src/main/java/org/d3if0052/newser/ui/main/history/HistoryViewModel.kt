package org.d3if0052.newser.ui.main.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0052.newser.db.News
import org.d3if0052.newser.db.NewsDao

class HistoryViewModel(private val db: NewsDao) : ViewModel() {
    val data = db.getHasilNews()
    fun hapusData() = viewModelScope.launch { withContext(Dispatchers.IO) {
        db.clearData() }
    }
}