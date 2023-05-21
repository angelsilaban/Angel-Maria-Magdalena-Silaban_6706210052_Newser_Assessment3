package org.d3if0052.newser.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if0052.newser.HomePageActivity
import org.d3if0052.newser.R
import org.d3if0052.newser.ui.main.MainAdapter
import org.d3if0052.newser.databinding.FragmentHomeBinding
import org.d3if0052.newser.model.Berita

@SuppressLint("NotifyDataSetChanged")
class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var beritaAdapter: MainAdapter
    private lateinit var list: ArrayList<Berita>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        list = ArrayList()
        list.addAll(getData())
        beritaAdapter = MainAdapter(list)

        with(binding.rvBerita) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = beritaAdapter
        }

        beritaAdapter.run { notifyDataSetChanged() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Newser"
        (activity as HomePageActivity).hideUpButton()

//        binding.addComment.setOnClickListener {
//            findNavController().navigate(
//                R.id.action_homeFragment_to_requestBeritaFragment)
//        }

        val buttonLihatBerita: Button = view.findViewById(R.id.button_lihat_berita)

        buttonLihatBerita.setOnClickListener(this)
    }

    private fun getData(): ArrayList<Berita> {
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

    override fun onClick(walah: View?) {
        if(walah?.id == R.id.button_lihat_berita) {
            val lihatBeritaUtamaFragment = LihatBeritaUtamaFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.content, lihatBeritaUtamaFragment, LihatBeritaUtamaFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}