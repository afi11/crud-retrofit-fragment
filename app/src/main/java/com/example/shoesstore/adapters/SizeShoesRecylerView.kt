package com.example.shoesstore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoesstore.R
import com.example.shoesstore.models.SizeShoes
import kotlinx.android.synthetic.main.row_shoe_size.view.*

class SizeShoesRecylerView(val clickLister: OnItemClickListener) : RecyclerView.Adapter<SizeShoesRecylerView.MyViewHolder>() {

    val sizeList = mutableListOf<SizeShoes>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SizeShoesRecylerView.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_shoe_size, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: SizeShoesRecylerView.MyViewHolder, position: Int) {
       holder.bind(sizeList[position])
        holder.itemView.setOnClickListener {
            clickLister.onItemDetailClick(sizeList[position])
        }

    }


    override fun getItemCount(): Int {
       return sizeList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewSize = view.textViewSize
        fun bind(data: SizeShoes){
            textViewSize.text = data.shoe_size
        }
    }

    interface OnItemClickListener {
        fun onItemDetailClick(sizeShoes: SizeShoes)
        fun initRecyclerView()
    }
}