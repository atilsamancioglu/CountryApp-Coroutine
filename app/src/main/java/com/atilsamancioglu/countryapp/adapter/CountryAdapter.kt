package com.atilsamancioglu.countryapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.atilsamancioglu.countryapp.R
import com.atilsamancioglu.countryapp.databinding.ItemCountryBinding
import com.atilsamancioglu.countryapp.model.Country
import com.atilsamancioglu.countryapp.util.downloadFromUrl
import com.atilsamancioglu.countryapp.util.placeholderProgressBar
import com.atilsamancioglu.countryapp.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener
{

    class CountryViewHolder(val view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = DataBindingUtil.inflate<ItemCountryBinding>(LayoutInflater.from(parent.context),R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.country = countryList.get(position)
        //holder.view.listener = this

        holder.itemView.setOnClickListener {
            val selectedCountry = countryList.get(position)
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(selectedCountry)
            Navigation.findNavController(it).navigate(action)

        }

        /*
        holder.itemView.name.text = countryList.get(position).countryName
        holder.itemView.region.text = countryList.get(position).countryRegion
        holder.itemView.imageView.downloadFromUrl(countryList.get(position).imageUrl,
            placeholderProgressBar(holder.itemView.context))
        holder.itemView.setOnClickListener {
        }

         */
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onCountryClicked(v: View) {
        println("tıklandı")

    }
}