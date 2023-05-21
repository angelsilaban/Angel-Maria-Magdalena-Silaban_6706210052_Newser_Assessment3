package org.d3if0052.newser.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if0052.newser.MainViewModel
import org.d3if0052.newser.MainViewModelFactory
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.FragmentRequestBeritaBinding
import org.d3if0052.newser.db.News
import org.d3if0052.newser.db.NewsDatabase

class FragmentRequestBerita : Fragment() {
    companion object {
        var NAMA = "nama"
    }
    private lateinit var binding: FragmentRequestBeritaBinding
    private val viewModel: MainViewModel by lazy {
        val db = NewsDatabase.getInstance(requireContext())
        val factory = MainViewModelFactory(db.newsDao())
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRequestBeritaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.next.setOnClickListener {
//            var nama = binding.namaInput.text.toString()
//            viewModel.getRequestBerita(nama)
        }
        binding.next.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_requestBeritaFragment
            )
        }

    }
}