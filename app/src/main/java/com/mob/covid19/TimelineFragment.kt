package com.mob.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mob.covid19.adapters.TimeLineAdapter
import com.mob.covid19.data.HistoricalWithDate
import com.mob.covid19.databinding.FragmentTimelineBinding
import com.mob.covid19.viewmodels.HistoricalViewModel


class TimelineFragment : Fragment() {

    private lateinit var binding: FragmentTimelineBinding
    private val historicalViewModel: HistoricalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimelineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historicalViewModel.initHistoricalData()
        val adapter = TimeLineAdapter()
        binding.countryRecycler.adapter = adapter
        historicalViewModel.getHistorical().observe(viewLifecycleOwner) { historical ->
            var keys = historical.cases.keys.toList()
            var his: List<HistoricalWithDate> =
                List<HistoricalWithDate>(historical.cases.keys.size) {
                    val date = keys.get(it)
                    var t = HistoricalWithDate(
                        historical.cases.get(date)!!,
                        historical.deaths.get(date)!!,
                        historical.recovered.get(date)!!,
                        date
                    )
                    t
                }
            adapter.submitList(his)
        }
    }

}