package com.mahmoudbashir.nytimesgenericapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.mahmoudbashir.nytimesgenericapp.R
import com.mahmoudbashir.nytimesgenericapp.adpaters.Popular_Adapter
import com.mahmoudbashir.nytimesgenericapp.databinding.FragmentHomeTimesBinding
import com.mahmoudbashir.nytimesgenericapp.interfaces.ItemClickInterface
import com.mahmoudbashir.nytimesgenericapp.pojo.results
import com.mahmoudbashir.nytimesgenericapp.repository.PopularRepository
import com.mahmoudbashir.nytimesgenericapp.ui.MainActivity
import com.mahmoudbashir.nytimesgenericapp.viewModel.PopularViewModel
import com.mahmoudbashir.nytimesgenericapp.viewModel.ViewModelProviderFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter

class HomeTimes_Fragment : Fragment() ,ItemClickInterface{
    lateinit var homeTimesBinding: FragmentHomeTimesBinding
    lateinit var popViewModel:PopularViewModel
    lateinit var adapter:Popular_Adapter
    lateinit var mlist:List<results>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeTimesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home_times, container, false)
        popViewModel = (activity as MainActivity).popViewModel
        adapter = Popular_Adapter(this.requireContext(),this)
        homeTimesBinding.recTimesArticles.setHasFixedSize(true)
        homeTimesBinding.recTimesArticles.adapter =adapter

 GlobalScope.launch(Dispatchers.Main){
     getData()
 }
 return homeTimesBinding.root
}
     private suspend fun getData(){
        homeTimesBinding.isLoading = true
        if (popViewModel.getPopular().isSuccessful){
            popViewModel.getPopular().body()?.let {it->

                homeTimesBinding.isLoading = false
                adapter.differ.submitList(it.results)

                Log.d("result: ", it.results[0].title)
            }
        }
    }

    override fun onClick(position:Int,imgUrl:String,title:String,articel_abstract:String) {
        val act = HomeTimes_FragmentDirections.actionHomeTimesFragmentToDetailsFragment(imgUrl,title,articel_abstract)
        findNavController().navigate(act)
    }
}