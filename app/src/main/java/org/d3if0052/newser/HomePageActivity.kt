package org.d3if0052.newser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if0052.newser.databinding.ActivityHomePageBinding
import kotlin.collections.ArrayList

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var beritaAdapter: MainAdapter
    private lateinit var list: ArrayList<Berita>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //memanggil class Adapter dengan data yang dimiliki
        list = ArrayList()
        list.addAll(getData())
        beritaAdapter = MainAdapter(list)

        with(binding.rvBerita) {
            layoutManager = LinearLayoutManager(this@HomePageActivity)
            adapter = beritaAdapter
        }

        beritaAdapter.run { notifyDataSetChanged() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)

        val searchItem = menu.findItem(R.id.seacrch_view)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                filter(query)
                return false
            }
        })

        return true
    }

    private fun filter(query: String) {
        val filteredList = arrayListOf<Berita>()

        for (item in list)
            if (item.title.lowercase().contains(query.lowercase())
            ) filteredList.add(item)

        if (filteredList.isEmpty()) Toast.makeText(
            this,
            "No data found!",
            Toast.LENGTH_SHORT
        ).show()
        else beritaAdapter.filtering(filteredList)
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
            )
        )
    }
}
