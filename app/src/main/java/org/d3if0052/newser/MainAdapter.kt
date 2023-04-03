package org.d3if0052.newser

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import org.d3if0052.newser.databinding.ActivityListBeritaBinding

class MainAdapter(private var beritalist: ArrayList<Berita>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), Filterable {

    class ViewHolder(
        val binding: ActivityListBeritaBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(berita: Berita) {
            Glide.with(binding.root)
                .load(berita.image)
                .into(binding.imageView)

            with(binding) {
                titleTextView.text = berita.title
            }
        }
    }

    var filterableList: ArrayList<Berita> = beritalist
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ActivityListBeritaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = filterableList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(beritalist[position])

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString().lowercase()

                filterableList = when {
                    charString.isEmpty() -> beritalist
                    else -> {
                        val filteringList = arrayListOf<Berita>()
                        for (data in beritalist) {
                            if (data.title.contains(charString, ignoreCase = true)) {
                                filteringList.add(data)
                            }
                        }
                        filteringList
                    }
                }

                val res = FilterResults()
                res.values = filterableList
                return res
            }

            //untuk menampilkan hasil data dari searchView
            override fun publishResults(str: CharSequence?, filter: FilterResults?) {
                filterableList = filter?.values as ArrayList<Berita>
            }

        }
    }

//        fun bind(berita: Berita) = with(binding) {
//            titleTextView.text = berita.title
//            descTextView.text = berita.desc
//            imageNarkoba.setImageResource(berita.image)
//        }
}

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ActivityListBeritaBinding.inflate(inflater, parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(data[position])
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    //melakukan menu searchView
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charString = constraint.toString().lowercase()
//
//                if (charString.isEmpty()) dataFiltered = data
//                else {
//                    data.let {
//                        val filtered = arrayListOf<Berita>()
//
//                        for (berita in data) {
//                            if (berita.title.lowercase()
//                                    .contains(charString) || berita.desc.lowercase()
//                                    .contains(charString)
//                            ) {
//                                filtered.add(berita)
//                            }
//                        }
//                        dataFiltered = filtered
//                    }
//                }
//                Log.wtf("AAAAAA", "performFiltering: $dataFiltered")
//
//                val res = FilterResults()
//                res.values = dataFiltered
//
//                return res
//            }
//            //untuk menampilkan hasil data dari searchView
//            override fun publishResults(str: CharSequence?, filter: FilterResults?) {
//                dataFiltered =
//                    if (filter?.values == null) arrayListOf()
//                    else filter.values as ArrayList<Berita>
//
//                Log.wtf("test", "publishResults: $dataFiltered")
//            }
//
//        }
//    }
//    private var dataFiltered: ArrayList<Berita>? = null
//    private val tempList = arrayListOf<Berita>()

//    fun loadData(newData: List<Berita>) {
//        tempList.apply {
//            clear()
//            addAll(newData)
//        }
//    }

// mengupdate list
//    fun updateList() {
//        tempList.addAll(data)
//        Log.wtf("AAAAAA", "resetList: $tempList")
//
//        if (dataFiltered!!.isNotEmpty()) {
//            data.clear()
//            data.addAll(dataFiltered!!)
//        }
//    }

//mereset list
//    fun resetList() {
//        data.clear()
//
//        Log.wtf("AAAAAA", "resetList: $tempList")
//        data.addAll(tempList)
//
//    }
