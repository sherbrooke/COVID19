package com.mob.covid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mob.covid19.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val frag = CurrentFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, frag, null).commit()
        initView()
    }

    private fun initView() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.current -> {
                    val frag = CurrentFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, frag, null).commit()
                    true
                }
                R.id.country -> {
                    val frag = CountryFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, frag, null).commit()
                    // Respond to navigation item 2 click
                    true
                }
                R.id.timeline -> {
                    val frag = TimelineFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, frag, null).commit()

                    true
                }
                else -> false
            }
        }

    }

}