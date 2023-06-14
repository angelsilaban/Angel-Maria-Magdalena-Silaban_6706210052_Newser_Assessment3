package org.d3if0052.newser.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.ActivityListBeritaBinding
import org.d3if0052.newser.model.Berita
import org.d3if0052.newser.network.BeritaApi

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var data = mutableListOf<Berita>()
    fun updateData(newData: ArrayList<Berita>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ActivityListBeritaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(berita: Berita) = with(binding) {
            titleTextView.text = berita.title
            descTextView.text = berita.desc
            Glide.with(imageNarkoba.context)
                .load(BeritaApi.getBeritaUrl(berita.image))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageNarkoba)

            root.setOnClickListener {
                Toast.makeText(root.context, berita.title, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityListBeritaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun filtering(filtered: ArrayList<Berita>) {
        data = filtered
        notifyDataSetChanged()
    }
}