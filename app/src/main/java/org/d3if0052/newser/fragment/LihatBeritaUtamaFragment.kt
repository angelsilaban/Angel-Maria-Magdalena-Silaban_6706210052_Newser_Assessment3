package org.d3if0052.newser.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.coroutines.NonCancellable
import org.d3if0052.newser.HomePageActivity
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
        binding.btnShareBerita.setOnClickListener {shareBerita() }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as HomePageActivity).showUpButton()
        (activity as HomePageActivity).clickUpButton()
    }

    //intent ke portal berita
    private fun shareBerita() {

        val message = getString(R.string.bagikan_berita)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
                    startActivity(Intent.createChooser(shareIntent, "share to "))
        }
    }

}