package com.example.tradeapp.ui.home.ads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.R
import kotlinx.android.synthetic.main.ads_item.view.*

class adsRecyclerAdapter(var AdsArray:List<adsModel> ):RecyclerView.Adapter<adsRecyclerAdapter.adsViewHolder>() {


    class adsViewHolder(var itemView : View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adsViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ads_item,parent,false)
        return adsViewHolder(view)
    }

    override fun onBindViewHolder(holder: adsViewHolder, position: Int) {

        holder.itemView.header.text=AdsArray.get(position).baslik
    }

    override fun getItemCount(): Int {
        return AdsArray.size
    }

   fun updatelist(ads:List<adsModel>){
        AdsArray=ads
    }


}