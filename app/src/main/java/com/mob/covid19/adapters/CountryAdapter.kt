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
        return VIewHolder(
            ListItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            , parent.context
        )
    }

    override fun onBindViewHolder(holder: VIewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }

    class VIewHolder(private val binding: ListItemCountryBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country) {
            Glide.with(context).load(item.countryInfo.flag).into(binding.countryFlag)
            binding.countryCases.text = "感染总数: " + item.cases.toString()
            binding.countryDeaths.text = "死亡总数: " + item.deaths.toString()
            binding.countryName.text =  item.country.toString()
            binding.countryRecovered.text = "治愈: " + item.recovered.toString()
            binding.countryTests.text = "疫苗: " + item.tests.toString()
            binding.countryTodayCases.text = "今日感染: " + item.todayCases.toString()
            binding.countryTodayDeaths.text = "今日死亡: " + item.todayDeaths.toString()
        }
    }
}

class CountryDiffCallback: DiffUtil.ItemCallback<Country> (){
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        val b = oldItem.country == newItem.country
        return oldItem.country == newItem.country
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        val b = oldItem == newItem
        return oldItem == newItem
    }

}

