package com.mob.covid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mob.covid19.data.CurrentData
import com.mob.covid19.data.CurrentDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentDataViewModel @Inject constructor(var repository: CurrentDataSource): ViewModel() {
    private  var data: MutableLiveData<CurrentData>? = null

     fun initData() {
         if (data == null) {
             data = MutableLiveData()
         }
            GlobalScope.launch {
                data!!.postValue( repository.getAll())
            }
    }

    fun getData():MutableLiveData<CurrentData>? {
        return data
    }


}