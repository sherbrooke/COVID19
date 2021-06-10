package com.mob.covid19.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mob.covid19.data.HistoricalWithDate
import com.mob.covid19.databinding.ListItemTimelineBinding

class TimeLineAdapter(): ListAdapter<HistoricalWithDate, TimeLineAdapter.VIewHolder>(TimelineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VIewHolder {
        return VIewHolder(
            ListItemTimelineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            , parent.context
        )
    }

    override fun onBindViewHolder(holder: VIewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }

    class VIewHolder(private val binding: ListItemTimelineBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HistoricalWithDate) {
            binding.dateNow.text = "日期: " + item.date
            binding.cases.text = "感染: " + item.case.toString()
            binding.deaths.text = "死亡: " + item.death.toString()
            binding.recovered.text = "治愈: " + item.recovered.toString()
        }
    }
}

class TimelineDiffCallback: DiffUtil.ItemCallback<HistoricalWithDate> (){
    override fun areItemsTheSame(oldItem: HistoricalWithDate, newItem: HistoricalWithDate): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: HistoricalWithDate, newItem: HistoricalWithDate): Boolean {
        return oldItem == newItem
    }

}

