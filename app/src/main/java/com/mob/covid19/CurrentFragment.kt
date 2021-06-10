package com.mob.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.mob.covid19.databinding.FragmentCurrentBinding
import com.mob.covid19.viewmodels.CurrentDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: 2021/6/9 每隔10分钟刷新一下数据
@AndroidEntryPoint
class CurrentFragment : Fragment() {

    private val currenModel: CurrentDataViewModel by activityViewModels()
    private lateinit var binding: FragmentCurrentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currenModel.initData()
        currenModel.getData()!!.observe(viewLifecycleOwner, Observer {
            binding.allDeath.text = it.deaths.toString()
            binding.allIncrease.text = it.cases.toString()
            binding.todayDeath.text = it.todayDeaths.toString()
            binding.allRecovered.text = it.recovered.toString()
            binding.allTests.text = it.tests.toString()
            binding.todayIncrease.text = it.todayCases.toString()
        })
    }


}