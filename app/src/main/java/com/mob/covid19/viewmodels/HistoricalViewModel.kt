package com.mob.covid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mob.covid19.data.CurrentDataSource
import com.mob.covid19.data.Historical
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoricalViewModel @Inject constructor(private val repository: CurrentDataSource):ViewModel() {

    private var historical: MutableLiveData<Historical>? = null

    fun initHistoricalData() {
        if (historical == null) {
            historical = MutableLiveData()
        }
        GlobalScope.launch {
            historical!!.postValue(repository.historicalAll())
        }

    }

    fun getHistorical(): MutableLiveData<Historical> {
        return historical!!

    }

}