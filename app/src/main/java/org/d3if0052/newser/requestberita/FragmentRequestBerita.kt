package org.d3if0052.newser.requestberita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if0052.newser.MainViewModel
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.FragmentRequestBeritaBinding
import org.d3if0052.newser.db.NewsDatabase

class FragmentRequestBerita : Fragment() {
    companion object {
        const val JUDUL = "judul"
    }

    private lateinit var binding: FragmentRequestBeritaBinding
    private val viewModel: RequestBeritaViewModel by lazy {
        val db = NewsDatabase.getInstance(requireContext())
        val factory = RequestBeritaViewModelFactory(db.newsDao)
        ViewModelProvider(this, factory)[RequestBeritaViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRequestBeritaBinding.inflate(layoutInflater, container, false)

//        binding.apply {
//            next.setOnClickListener{
//                namaInput.text.toString()
//            }
//        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.namaInput.setOnClickListener {
//            val judul = binding.namaInput.text.toString()
//            viewModel.getData(judul)
//        }
        binding.next.setOnClickListener {
            val judul = binding.namaInput.text.toString()
            viewModel.getData(judul)
//            findNavController().navigate(
//                R.id.action_homeFragment_to_historyFragment)
        }
        }
    }


