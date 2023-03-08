package com.example.tradeapp.ui.home.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.R
import com.example.tradeapp.ui.home.ads.adsModel
import com.example.tradeapp.ui.home.ads.adsRecyclerAdapter


class categoryRecyclerAdapter(var CategoryList:List<CategoryModel>):RecyclerView.Adapter<categoryRecyclerAdapter.categoryViewHolder>() {
    class categoryViewHolder(var itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.category_item,parent,false)
        return categoryViewHolder(view)
     }

    override fun onBindViewHolder(holder: categoryViewHolder, position: Int) {
     }

    override fun getItemCount(): Int {
        return CategoryList.size
     }

    fun updatelist(CategoryList_:List<CategoryModel>){
        CategoryList=CategoryList_
    }

}