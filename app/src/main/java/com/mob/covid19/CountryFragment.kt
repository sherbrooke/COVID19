package com.mob.covid19

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mob.covid19.adapters.CountryAdapter
import com.mob.covid19.databinding.FragmentCountryBinding
import com.mob.covid19.viewmodels.CountryVIewModel


// TODO: 2021/6/9 请求每个国家的数据
class CountryFragment : Fragment() {

    private lateinit var binding: FragmentCountryBinding
    private val countryModel: CountryVIewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryModel.initCountryData()
        val adapter = CountryAdapter()
        binding.countryRecycler.adapter = adapter
        countryModel.getCountry()!!.observe(viewLifecycleOwner, {
//            todo 将list根据case数量排序,或者提供一个可以排序的工具
            adapter.submitList(it)
        })

    }

}