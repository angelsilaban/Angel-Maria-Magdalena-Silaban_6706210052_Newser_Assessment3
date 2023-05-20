package org.d3if0052.newser.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.d3if0052.newser.R
import org.d3if0052.newser.SearchViewModel
import org.d3if0052.newser.data.SettingDataStore
import org.d3if0052.newser.data.dataStore
import org.d3if0052.newser.databinding.FragmentSearchBinding
import org.d3if0052.newser.model.Berita

class SearchFragment : Fragment() {

    //mvvm
    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }

    private lateinit var binding: FragmentSearchBinding
    private lateinit var simpleList: ListView
    private lateinit var myAdapter: MainAdapter
//    lateinit var isLinearLayout : isLinearLayout

    //datastore
    private val layoutDataStore: SettingDataStore by lazy {
        SettingDataStore(requireContext().dataStore)
    }

    private val list = arrayOf("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        //myAdapter = MainAdapter()

        with(binding.rvBerita) {
            adapter = myAdapter
            setHasFixedSize(true)
        }

//        simpleList = binding.ahhh
//        val arrAdapter = ArrayAdapter(requireContext(), R.layout.fragment_search, R.id.tv_ahhh, list)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner) {
//            isLinearLayout = it
//            setLayout()
//            activity?.invalidateOptionsMenu()
//       }

        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.content) {
            lifecycleScope.launch {
                //layoutDataStore.saveLayout(!isLinearLayout, requireContext())
            }
//            layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner) {
//                isLinearLayout = it
//                setLayout()
//                activity?.invalidateOptionsMenu()
//            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //    private fun filter(query: String) {
//        val filteredList = arrayListOf<String>()
//
//        for (item in list)
//            if (item.lowercase().contains(query.lowercase())
//            ) filteredList.add(item)
//
//        if (filteredList.isEmpty()) Toast.makeText(
//            requireContext(),
//            "No data found!",
//            Toast.LENGTH_SHORT
//        ).show()
//        else beritaAdapter.filtering(filteredList)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_item, menu)
//
//        val searchItem = menu.findItem(R.id.search_view)
//        val searchView = searchItem.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(query: String): Boolean {
//                filter(query)
//                return false
//            }
//        })
//    }
}

