package org.d3if0052.newser.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if0052.newser.HomePageActivity
import org.d3if0052.newser.MainViewModel
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.FragmentHomeBinding
import org.d3if0052.newser.network.ApiStatus
import org.d3if0052.newser.network.BeritaApi
import org.d3if0052.newser.ui.main.MainAdapter

@SuppressLint("NotifyDataSetChanged")
class HomeFragment : Fragment(), View.OnClickListener {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var binding: FragmentHomeBinding
    private lateinit var beritaAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        beritaAdapter = MainAdapter()

        beritaAdapter.run { notifyDataSetChanged() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {
            beritaAdapter.updateData(it)

            with(binding.rvBerita) {
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        RecyclerView.VERTICAL
                    )
                )

                adapter = beritaAdapter
                setHasFixedSize(true)
            }
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }

        viewModel.scheduleUpdater(requireActivity().application)

        (activity as AppCompatActivity).supportActionBar?.title = "Newser"
        (activity as HomePageActivity).hideUpButton()

        val buttonLihatBerita: Button = view.findViewById(R.id.button_lihat_berita)

        buttonLihatBerita.setOnClickListener(this)
    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
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