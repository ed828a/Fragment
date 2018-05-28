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
import com.dew.edward.kotlinfragment.utilities.ImageUrl03
import kotlinx.android.synthetic.main.fragment_third.*


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ThirdImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    private fun loadImageUsingGlide(){
        progressBarThirdFragment.visibility = View.VISIBLE
        GlideApp.with(activity)
                .asBitmap()
                .load(Uri.parse(ImageUrl03))
                .into(object : BitmapImageViewTarget(imageThirdFragment){
                    override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                        super.onResourceReady(resource, transition)
                        progressBarThirdFragment.visibility = View.INVISIBLE
                    }
                })
    }

    companion object {
        fun newInstance() = ThirdImageFragment()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadImageUsingGlide()
    }

}
