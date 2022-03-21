package com.example.shoesstore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoesstore.R
import com.example.shoesstore.models.Brand
import com.example.shoesstore.utils.Url
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_home_brand.view.*

class BrandRecyclerView(): RecyclerView.Adapter<BrandRecyclerView.MyViewHolder>() {

    var brandList = mutableListOf<Brand>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandRecyclerView.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_home_brand, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BrandRecyclerView.MyViewHolder, position: Int) {
        holder.bind(brandList[position])
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageViewBrand = view.imageViewBrand
        fun bind(data: Brand){
            Picasso.get().load(Url.url_img_brand+data.brand_photo).into(imageViewBrand)
        }
    }
}