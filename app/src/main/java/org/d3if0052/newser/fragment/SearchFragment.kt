package org.d3if0052.newser.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.FragmentSearchBinding
import org.d3if0052.newser.model.Berita

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var simpleList: ListView

    private val list = arrayOf("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        simpleList = binding.ahhh
        val arrAdapter = ArrayAdapter(requireContext(), R.layout.fragment_search, R.id.tv_ahhh, list)

        return binding.root
    }

    private fun filter(query: String) {
        val filteredList = arrayListOf<String>()

        for (item in list)
            if (item.lowercase().contains(query.lowercase())
            ) filteredList.add(item)

        if (filteredList.isEmpty()) Toast.makeText(
            requireContext(),
            "No data found!",
            Toast.LENGTH_SHORT
        ).show()
        else beritaAdapter.filtering(filteredList)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)

        val searchItem = menu.findItem(R.id.search_view)
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
    }
}