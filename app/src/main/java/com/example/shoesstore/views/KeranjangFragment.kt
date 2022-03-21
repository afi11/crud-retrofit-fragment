package com.example.shoesstore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoesstore.R

class KeranjangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keranjang, container, false)
    }

    companion object {
        fun newInstance() : KeranjangFragment{
            val fragment = KeranjangFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}