package com.mahmoudbashir.nytimesgenericapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mahmoudbashir.nytimesgenericapp.R
import com.mahmoudbashir.nytimesgenericapp.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class Details_Fragment : Fragment() {
    lateinit var detailsBinding:FragmentDetailsBinding
    var title:String? = null
    var imgUrl:String? = null
    var articleAbstract:String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details_, container, false)
       title = arguments?.let { Details_FragmentArgs.fromBundle(it).title }
       imgUrl = arguments?.let { Details_FragmentArgs.fromBundle(it).imgUrl }
       articleAbstract = arguments?.let { Details_FragmentArgs.fromBundle(it).articleAbstract }


        detailsBinding.txtTitle.text=title
        detailsBinding.txtArticleAbstract.text=articleAbstract
        Picasso.get().load(imgUrl).placeholder(R.drawable.ic_launcher_background).into(detailsBinding.imgUrl)

        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        return detailsBinding.root
    }

}