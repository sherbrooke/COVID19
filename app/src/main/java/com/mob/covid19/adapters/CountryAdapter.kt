package com.mob.covid19.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mob.covid19.data.Country
import com.mob.covid19.databinding.FragmentCountryBinding
import com.mob.covid19.databinding.ListItemCountryBinding
import kotlin.math.log

class CountryAdapter(): ListAdapter<Country, CountryAdapter.VIewHolder>(CountryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VIewHolder {
        Log.e("ssss", "onCreateViewHolder" )
        return VIewHolder(
            ListItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            , parent.context
        )
    }

    override fun onBindViewHolder(holder: VIewHolder, position: Int) {
        Log.e("ssss", "onBindViewHolder")
        val country = getItem(position)
        holder.bind(country)
    }

    class VIewHolder(private val binding: ListItemCountryBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country) {
            Log.e("ssss", "binding" + item.cases.toString())
            Glide.with(context).load(item.countryInfo.flag).into(binding.countryFlag)
            binding.countryCases.text = item.cases.toString()
            binding.countryDeaths.text = item.deaths.toString()
            binding.countryName.text = item.country.toString()
            binding.countryRecovered.text = item.recovered.toString()
            binding.countryTests.text = item.tests.toString()
            binding.countryTodayCases.text = item.todayCases.toString()
            binding.countryTodayDeaths.text = item.todayDeaths.toString()
        }
    }
}

class CountryDiffCallback: DiffUtil.ItemCallback<Country> (){
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        val b = oldItem.country == newItem.country
        Log.e("ssss0", b.toString())
        return oldItem.country == newItem.country
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        val b = oldItem == newItem
        Log.e("ssss1", b.toString())
        return oldItem == newItem
    }

}

