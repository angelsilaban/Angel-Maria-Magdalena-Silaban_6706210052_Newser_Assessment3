package org.d3if0052.newser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import org.d3if0052.newser.adapter.MainAdapter
import org.d3if0052.newser.databinding.ActivityHomePageBinding
import org.d3if0052.newser.fragment.CategoriesFragment
import org.d3if0052.newser.fragment.HistoryFragment
import org.d3if0052.newser.fragment.HomeFragment
import org.d3if0052.newser.fragment.LikeFragment
import org.d3if0052.newser.model.Berita


class HomePageActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityHomePageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_beranda -> addFragment(HomeFragment())
                R.id.ic_categories -> addFragment(CategoriesFragment())
                R.id.ic_like -> addFragment(LikeFragment())
                R.id.ic_history -> addFragment(HistoryFragment())

                else->{

                }
            }
            true
        }

    }

    private fun addFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content,fragment)
        fragmentTransaction.commit()
    }
}

