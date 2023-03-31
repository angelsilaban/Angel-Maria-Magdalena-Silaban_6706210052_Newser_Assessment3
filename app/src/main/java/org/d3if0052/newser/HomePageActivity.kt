package org.d3if0052.newser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import org.d3if0052.newser.databinding.ActivityHomePageBinding
class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val beritaAdaptar = MainAdapter(getData())

        binding.recycleViewListBerita.adapter = beritaAdaptar;

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                binding.search.clearFocus()

                beritaAdaptar.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                beritaAdaptar.filter.filter(newText)
                return false
            }

        })

        with(binding.recycleViewListBerita) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }
    }
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