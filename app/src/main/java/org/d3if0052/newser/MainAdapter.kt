package org.d3if0052.newser

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.d3if0052.newser.databinding.ActivityListBeritaBinding

class MainAdapter(private val data: ArrayList<Berita>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), Filterable {
    private var dataFiltered = arrayListOf<Berita>()

    class ViewHolder(
        private val binding: ActivityListBeritaBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(berita: Berita) = with(binding) {
            titleTextView.text = berita.title
            descTextView.text = berita.desc
            imageView.setImageResource(berita.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityListBeritaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""

                dataFiltered = if (charString.isEmpty()) data else {
                    val filtered = arrayListOf<Berita>()

                    data.filter {
                        (it.title.contains(constraint!!)) or (it.desc.contains(constraint))
                    }.forEach { filtered.add(it) }
                    filtered
                }

                return FilterResults().apply { values = dataFiltered }
            }

            override fun publishResults(str: CharSequence?, filter: FilterResults?) {
                dataFiltered =
                    if (filter?.values == null) arrayListOf()
                    else filter.values as ArrayList<Berita>
            }

        }
    }
}
