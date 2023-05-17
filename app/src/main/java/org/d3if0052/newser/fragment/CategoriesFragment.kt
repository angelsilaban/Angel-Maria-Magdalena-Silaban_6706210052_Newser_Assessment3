package org.d3if0052.newser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if0052.newser.databinding.FragmentCategoriesBinding
import org.d3if0052.newser.databinding.FragmentHomeBinding

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}