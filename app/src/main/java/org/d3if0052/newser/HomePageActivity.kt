package org.d3if0052.newser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if0052.newser.databinding.ActivityHomePageBinding
import kotlin.collections.ArrayList

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private var beritalist = arrayListOf<Berita>()
    private lateinit var beritaAdapter: MainAdapter
    private val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for (i in beritalist.indices) {
            list.add(beritalist[i].title)
        }

//        beritalist.addAll(getData())
        beritaAdapter = MainAdapter(getData())

        with(binding.rvBerita) {
            layoutManager = LinearLayoutManager(this@HomePageActivity)
            adapter = beritaAdapter
            setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)

        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        performSearching(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    //melakukan pencarian data dan menghubungkan dengan class Main Adapter
    private fun performSearching(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                for (i in list.indices) {
                    Log.wtf("AEAEAE", "onQueryTextSubmit: ${list[i]}")

                    if (list[i].contains(query!!)) {
                        beritaAdapter.filter.filter(query)
                    }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                beritaAdapter.filter.filter(p0)
                return true
            }
        })
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
//
//            //melakukan penghapusan data dan mereset list dan menghubungkan dengan class Main Adapter
//            override fun onQueryTextChange(newText: String?): Boolean {
//                (binding.recycleViewListBerita.adapter as MainAdapter).filter.filter(newText)
//
//                Log.wtf("AAAAAAA", "request: $newText")
//                beritaAdaptar.updateList()
//
//                if (newText!!.isEmpty() || newText.isBlank()) beritaAdaptar.resetList()
//                return false
//            }

//        })