package org.d3if0052.newser

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.d3if0052.newser.databinding.ActivityListBeritaBinding

class MainAdapter(private var data: ArrayList<Berita>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), Filterable {
    private var dataFiltered: ArrayList<Berita>? = null
    private var tempList = arrayListOf<Berita>()

    // mengupdate list
    fun updateList() {
        tempList.addAll(data)
        Log.wtf("AAAAAA", "resetList: $tempList")

        if (dataFiltered!!.isNotEmpty()) {
            data.clear()
            data.addAll(dataFiltered!!)
        }
    }

    //mereset list
    fun resetList() {
        data.clear()

        Log.wtf("AAAAAA", "resetList: $tempList")
        data.addAll(tempList)

    }

    //membuat class viewholder untuk menampilkan informasi yang ada di list_item
    class ViewHolder(
        private val binding: ActivityListBeritaBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(berita: Berita) = with(binding) {
            titleTextView.text = berita.title
            descTextView.text = berita.desc
            imageNarkoba.setImageResource(berita.image)
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

    //melakukan menu searchView
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString().lowercase()

                if (charString.isEmpty()) dataFiltered = data
                else {
                    data.let {
                        val filtered = arrayListOf<Berita>()

                        for (berita in data) {
                            if (berita.title.lowercase()
                                    .contains(charString) || berita.desc.lowercase()
                                    .contains(charString)
                            ) {
                                filtered.add(berita)
                            }
                        }
                        dataFiltered = filtered
                    }
                }
                Log.wtf("AAAAAA", "performFiltering: $dataFiltered")

                val res = FilterResults()
                res.values = dataFiltered

                return res
            }
            //untuk menampilkan hasil data dari searchView
            override fun publishResults(str: CharSequence?, filter: FilterResults?) {
                dataFiltered =
                    if (filter?.values == null) arrayListOf()
                    else filter.values as ArrayList<Berita>

                Log.wtf("test", "publishResults: $dataFiltered")
            }

        }
    }
}
