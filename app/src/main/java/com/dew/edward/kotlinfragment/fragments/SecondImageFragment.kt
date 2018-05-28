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
import com.dew.edward.kotlinfragment.utilities.ImageUrl02
import kotlinx.android.synthetic.main.fragment_second_image.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_image, container, false)
    }

    private fun loadImageUsingGlide(){
        progressBarSecondFragment.visibility = View.VISIBLE
        GlideApp.with(activity)
                .asBitmap()
                .load(Uri.parse(ImageUrl02))
                .into(object : BitmapImageViewTarget(imageSecondFragment){
                    override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                        super.onResourceReady(resource, transition)
                        progressBarSecondFragment.visibility = View.INVISIBLE
                    }
                })
    }

    companion object {
        fun newInstance() = SecondImageFragment()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadImageUsingGlide()
    }
}
