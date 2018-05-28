package com.dew.edward.kotlinfragment.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.dew.edward.kotlinfragment.fragments.FirstImageFragment
import com.dew.edward.kotlinfragment.fragments.SecondImageFragment

/*
 * Created by Edward on 5/28/2018.
 */

class ImageFragmentPagerAdapter(fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstImageFragment.newInstance()
            1 -> SecondImageFragment.newInstance()
            else -> FirstImageFragment.newInstance()
        }
    }

    override fun getCount(): Int = 2
}