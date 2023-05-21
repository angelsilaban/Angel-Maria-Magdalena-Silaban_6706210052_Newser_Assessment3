package org.d3if0052.newser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0052.newser.db.NewsDao
import org.d3if0052.newser.model.Berita

class MainViewModel (db: NewsDao) : ViewModel() {
//    val data = db.getAll()
    private var data = MutableLiveData<ArrayList<Berita>>()

    init {
        data.value = initData()
    }

    private fun initData(): ArrayList<Berita> {
        return arrayListOf(
            Berita(
                "Polisi tangkap 21  tersangka narkoba di Bogor, \n sabu hingga 0bat keras disita.",
                "Newser - 16/05/2023",
                R.drawable.image_narkoba
            ),

            Berita(
                "Salah satu pulau terpadat di dunia ternyata \n milik Indonesia.",
                "Newser - 16/05/2023",
                R.drawable.image_pulau
            ),

            Berita(
                "Jokowi Belum Mau Komentari RUU TNI Soal \n Jabatan Sipil Diisi Militer.",
                "Newser - 17/05/2023",
                R.drawable.images_ruu_tni
            ),

            Berita(
                "Panglima TNI Klarifikasi 4 Pekerja BTS Kominfo \n Bukan Disandera KKB.",
                "Newser - 17/05/2023",
                R.drawable.images_panglima_tni
            )
        )
    }
    fun getData(): LiveData<ArrayList<Berita>> = data
}

class MainViewModelFactory(
    private val db: NewsDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") }
}