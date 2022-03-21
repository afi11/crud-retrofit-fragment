package com.example.shoesstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.shoesstore.views.HomeFragment
import com.example.shoesstore.views.KeranjangFragment
import com.example.shoesstore.views.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initView()

    }

    private fun initView() {
        val home = HomeFragment.newInstance()
        addFragment(home)

        // Toolbar
        val toolbar : Toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Home")
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.menu_home -> {
                val home = HomeFragment.newInstance()
                addFragment(home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_cart -> {
                val keranjang = KeranjangFragment.newInstance()
                addFragment(keranjang)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_profil -> {
                val profil = ProfilFragment.newInstance()
                addFragment(profil)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}