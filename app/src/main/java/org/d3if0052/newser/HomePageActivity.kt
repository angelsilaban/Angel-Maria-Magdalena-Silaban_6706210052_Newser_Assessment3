package org.d3if0052.newser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if0052.newser.databinding.ActivityHomePageBinding
import kotlin.collections.ArrayList

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //memanggil class Adapter dengan data yang dimiliki
        val beritaAdaptar = MainAdapter(getData())

        //melakukan pencarian data dan menghubungkan dengan class Main Adapter
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                (binding.recycleViewListBerita.adapter as MainAdapter).filter.filter(query)

                Log.wtf("AAAAAAA", "request: $query")
                beritaAdaptar.updateList()

                return false
            }

            //melakukan penghapusan data dan mereset list dan menghubungkan dengan class Main Adapter
            override fun onQueryTextChange(newText: String?): Boolean {
                (binding.recycleViewListBerita.adapter as MainAdapter).filter.filter(newText)

                Log.wtf("Coba", "request: $newText")
                beritaAdaptar.updateList()

                if (newText!!.isEmpty() || newText.isBlank()) beritaAdaptar.resetList()
                return false
            }

        })

        with(binding.recycleViewListBerita) {
            layoutManager = LinearLayoutManager(this@HomePageActivity)
            adapter = beritaAdaptar
            setHasFixedSize(true)
        }

    }

    // membuat list data dengan arrayList
    private fun getData(): ArrayList<Berita> {
        return arrayListOf(
            Berita(
                "Polisi tangkap 21  tersangka narkoba di Bogor, sabu hingga 0bat keras disita.",
                "Newser - 3 jam yang lalu",
                R.drawable.image_narkoba
            ),

            Berita(
                "Salah satu pulau terpadat di dunia ternyata milik Indonesia.",
                "Newser - 5 jam yang lalu",
                R.drawable.image_pulau
            ),

            Berita(
                "Tesla Cybertruck belum meluncur, kaum tajir Indonesia sudah antre mau beli.",
                "Newser - 9 jam yang lalu",
                R.drawable.image_tesla
            ),

            Berita(
                "Potret Tanaman Bibit Cerdas yang Bantu Tingkatkan Hasil Panen di China.",
                "Newser - 14 jam yang lalu",
                R.drawable.image_tanamanbibitcerdas
            ),

            Berita(
                "Aksi Protes Massal di Israel Berlanjut.",
                "Newser -16 jam yang lalu",
                R.drawable.image_protesisrael
            ),

            Berita(
                "Pesawat Kelima Pelita Air Sudah Datang, untuk Mudik 2023.",
                "Newser -18 jam yang lalu",
                R.drawable.image_pesawatpelitaair
            ),
        )
    }
}
