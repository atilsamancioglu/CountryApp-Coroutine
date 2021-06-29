package com.atilsamancioglu.countryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.atilsamancioglu.countryapp.R
import com.atilsamancioglu.countryapp.adapter.CountryAdapter
import com.atilsamancioglu.countryapp.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    val feedViewModel : FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryList.layoutManager = LinearLayoutManager(requireContext())

        observeLiveData()
    }

    private fun observeLiveData() {

        feedViewModel.downloadData()

        feedViewModel.countries.observe(viewLifecycleOwner) {
            val adapter = CountryAdapter(ArrayList(it))
            countryList.adapter = adapter
            countryList.visibility = View.VISIBLE
        }

        feedViewModel.countryError.observe(viewLifecycleOwner) {
            if(it) {
                //hata var
                countryError.visibility = View.VISIBLE
            } else {
                //hata yok
                countryError.visibility = View.GONE
            }
        }

        feedViewModel.countryLoading.observe(viewLifecycleOwner) {
            if (it) {
                //yükleniyor
                countryLoading.visibility = View.VISIBLE
                countryList.visibility = View.GONE
                countryError.visibility = View.GONE
            } else {
                countryLoading.visibility = View.GONE
            }
        }

    }


}