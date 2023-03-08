package com.example.tradeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tradeapp.ui.home.ads.adsModel
import com.example.tradeapp.ui.home.categories.CategoryModel

class HomeViewModel : ViewModel() {
     var ads= MutableLiveData<List<adsModel>>()
     var Category= MutableLiveData<List<CategoryModel>>()
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init{
       ads.value= getadsData()
        Category.value= getcategoryData()

    }

    private fun getadsData():List<adsModel> {
        val array = arrayListOf<adsModel>()
        for (i in 0..7){
            val ad=adsModel(i,"deneme","url")
            array.add(ad)
        }
        return array

    }
    private fun getcategoryData():List<CategoryModel> {
        val array = arrayListOf<CategoryModel>()
        for (i in 0..3){
            val ad=CategoryModel(i,"deneme","url")
            array.add(ad)
        }
        return array

    }
}


