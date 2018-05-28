package com.dew.edward.kotlinfragment.fragments

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.dew.edward.kotlinfragment.R
import com.dew.edward.kotlinfragment.utilities.GlideApp
import com.dew.edward.kotlinfragment.utilities.ImageUrl
import kotlinx.android.synthetic.main.fragment_first_image.*

/*
 * Created by Edward on 5/27/2018.
 */

class FirstImageFragment : Fragment(){
    private fun loadImageUsingGlide(){
        progressBarFirstFragment.visibility = View.VISIBLE
        GlideApp.with(activity)
                .asBitmap()
                .load(Uri.parse(ImageUrl))
                .into(object : BitmapImageViewTarget(imageFirstFragment){
                    override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                        super.onResourceReady(resource, transition)
                        progressBarFirstFragment.visibility = View.INVISIBLE
                    }
                })
    }

    companion object {
        fun newInstance() = FirstImageFragment()

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadImageUsingGlide()
    }
}