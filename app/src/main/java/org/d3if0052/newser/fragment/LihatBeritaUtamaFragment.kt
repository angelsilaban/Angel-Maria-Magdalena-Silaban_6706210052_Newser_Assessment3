package org.d3if0052.newser.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.NonCancellable
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.FragmentCategoriesBinding
import org.d3if0052.newser.databinding.FragmentLihatBeritaUtamaBinding

class LihatBeritaUtamaFragment : Fragment() {

    private lateinit var binding : FragmentLihatBeritaUtamaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLihatBeritaUtamaBinding.inflate(layoutInflater, container, false)
        return binding.root
        binding.buttonSelengkapnya.setOnClickListener { lihatBerita() }
    }

    //intent ke portal berita
    private fun lihatBerita() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}