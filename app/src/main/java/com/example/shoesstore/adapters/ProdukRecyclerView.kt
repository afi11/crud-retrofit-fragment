package com.example.shoesstore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoesstore.R
import com.example.shoesstore.models.Product
import com.example.shoesstore.utils.Url
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_home_produk.view.*

class ProdukRecyclerView(val clickListener: OnItemClickListener) : RecyclerView.Adapter<ProdukRecyclerView.MyViewHolder>() {

    var produkList = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukRecyclerView.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_home_produk, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ProdukRecyclerView.MyViewHolder, position: Int) {
        holder.bind(produkList[position])
        holder.itemView.setOnClickListener {
            clickListener.onItemDetailClick(produkList[position])
        }
    }

    override fun getItemCount(): Int {
        return produkList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProduk = view.imageViewProduk
        val produkName = view.textViewProdukName
        val produkPrice = view.textViewProdukHarga
        val produkKategori = view.textViewProdukKategori
        fun bind(data: Product) {
            Picasso.get().load(Url.url_img_produk+data.shoes_foto).into(imageProduk)
            produkName.text = data.shoes_name
            produkPrice.text = data.shoes_price
            produkKategori.text = data.kategori_nama
        }
    }

    interface OnItemClickListener {
        fun onItemDetailClick(product: Product)
    }

}