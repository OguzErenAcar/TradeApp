package com.example.tradeapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tradeapp.databinding.FragmentHomeBinding
import com.example.tradeapp.ui.home.ads.adsRecyclerAdapter
import com.example.tradeapp.ui.home.categories.categoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var Ads_adapter =adsRecyclerAdapter(arrayListOf())
    private var Category_adapter =categoryRecyclerAdapter(arrayListOf())

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel:HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        _binding!!.adsRecycler.layoutManager= object : GridLayoutManager(context ,2)
        {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        _binding!!.adsRecycler.adapter=Ads_adapter
        observeAds()


        _binding!!.categoriesRecyler.layoutManager=object :LinearLayoutManager(context,HORIZONTAL,false)
        {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        _binding!!.categoriesRecyler.adapter=Category_adapter
        observeCategory()

        return root
    }

    fun observeAds(){
        homeViewModel.ads.observe(viewLifecycleOwner, Observer {
            Ads_adapter.updatelist(it)
            //burda Ads_adapter.adsRecyclerAdapter(it) çalışmaması ?
        })
    }
    fun observeCategory(){
        homeViewModel.Category.observe(viewLifecycleOwner, Observer {
            Category_adapter.updatelist(it)
            //burda Ads_adapter.adsRecyclerAdapter(it) çalışmaması ?
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}