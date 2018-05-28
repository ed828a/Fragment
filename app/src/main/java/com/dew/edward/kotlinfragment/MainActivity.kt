package com.dew.edward.kotlinfragment

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.dew.edward.kotlinfragment.fragments.FirstImageFragment
import com.dew.edward.kotlinfragment.fragments.SecondImageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val drawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        drawerLayout.addDrawerListener(drawerToggle)
        navigationView.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }
    }

    // configure configuration and synchronization between drawToggle and drawLayout
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    private fun selectDrawerItem(item: MenuItem){
        var fragment: Fragment? = null
        val fragmentClass = when(item.itemId){
            R.id.firstFragmentItem -> FirstImageFragment::class.java
            R.id.secondFragmentItem -> SecondImageFragment::class.java
            else -> FirstImageFragment::class.java
        }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: ClassCastException){
            e.printStackTrace()
        }

        replaceFragment(fragment)
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun replaceFragment(fragment: Fragment?) {
        if (fragment != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.fragment_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        return when (item?.itemId) {
//            R.id.firstFragmentItem -> {
//                val fragment = FirstImageFragment.newInstance()
//                replaceFragment(fragment)
//                true
//            }
//
//            R.id.secondFragmentItem -> {
//                val fragment = SecondImageFragment.newInstance()
//                replaceFragment(fragment)
//                true
//            }
//
//            else -> super.onOptionsItemSelected(item)
//
//        }
        // disable onOptionsItemSelected
        return if (drawerToggle.onOptionsItemSelected(item)) true
        else super.onOptionsItemSelected(item)
    }
}
