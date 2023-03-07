package com.example.tradeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tradeapp.ui.home.ads.adsModel

class HomeViewModel : ViewModel() {
     var ads= MutableLiveData<List<adsModel>>()
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init{
       ads.value= getData()
    }

    private fun getData():List<adsModel> {
        val array = arrayListOf<adsModel>()
        for (i in 0..7){
            val ad=adsModel(i,"deneme","url")
            array.add(ad)
        }
        return array

    }

}


