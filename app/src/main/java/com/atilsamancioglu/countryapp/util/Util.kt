package com.atilsamancioglu.countryapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

//extension
fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {
    Glide.with(context).load(url).into(this)
}


fun placeholderProgressBar(context : Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        centerRadius = 40f
        strokeWidth = 8f
        start()
    }
}

@BindingAdapter("android:downloadUrl")
fun downloadImage(view:ImageView, url:String?) {
    view.downloadFromUrl(url, placeholderProgressBar(view.context))
}