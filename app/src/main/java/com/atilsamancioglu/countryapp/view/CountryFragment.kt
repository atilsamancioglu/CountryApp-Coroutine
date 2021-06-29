package com.atilsamancioglu.countryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.atilsamancioglu.countryapp.R
import com.atilsamancioglu.countryapp.databinding.FragmentCountryBinding
import com.atilsamancioglu.countryapp.model.Country
import com.atilsamancioglu.countryapp.util.downloadFromUrl
import com.atilsamancioglu.countryapp.util.placeholderProgressBar
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    private lateinit var dataBinding : FragmentCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
           val selectedCountry = CountryFragmentArgs.fromBundle(it).selectedCountry
            dataBinding.selectedCountry = selectedCountry
        }

    }
}