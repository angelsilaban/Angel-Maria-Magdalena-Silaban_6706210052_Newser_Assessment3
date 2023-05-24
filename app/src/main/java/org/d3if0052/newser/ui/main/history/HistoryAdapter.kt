package org.d3if0052.newser.ui.main.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0052.newser.R
import org.d3if0052.newser.databinding.ItemHistoryBinding
import org.d3if0052.newser.db.News
import java.text.SimpleDateFormat
import java.util.*


class HistoryAdapter : ListAdapter<News, HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<News>() {
                override fun areItemsTheSame(
                    oldItem: News, newItem: News
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: News, newItem: News
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    class ViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

        fun bind(item: News) {
            binding.tanggaltv.text = dateFormatter.format(Date(item.tanggal))
            binding.judultv.text = item.judul
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}