package com.example.shoesstore.views.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shoesstore.R
import com.example.shoesstore.adapters.SizeShoesRecylerView
import com.example.shoesstore.models.ProductResponse
import com.example.shoesstore.models.SizeShoes
import com.example.shoesstore.models.SizeShoesResponse
import com.example.shoesstore.utils.Url
import com.example.shoesstore.viewmodels.DetProductViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_det_product.*
import kotlinx.android.synthetic.main.row_shoe_size.*

class DetProductActivity : AppCompatActivity(), SizeShoesRecylerView.OnItemClickListener {

    lateinit var detProductViewModel: DetProductViewModel
    lateinit var sizeShoesRecylerView: SizeShoesRecylerView
    var productId : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_det_product)
        productId = intent.getStringExtra("productId")
        initViewModel()
        loadDetailData(productId)
        loadSizeProduct(productId)

        initRecyclerView()

    }

    private fun initViewModel() {
        detProductViewModel = ViewModelProvider(this).get(DetProductViewModel::class.java)
    }

    private fun loadSizeProduct(id: String?){
        detProductViewModel.getSizeProductObserveable().observe(this, Observer<SizeShoesResponse?>{
            if(it == null) {
                Toast.makeText(this, "no result found", Toast.LENGTH_SHORT).show()
            }else{
               textViewSize.text = it.data!!.shoe_size
            }
        })
        detProductViewModel.getSizeProduct(id)
    }

    private fun loadDetailData(id: String?) {
        detProductViewModel.getDetProductObserveable().observe(this, Observer<ProductResponse?>{
            if(it == null) {
                Toast.makeText(this, "no result found", Toast.LENGTH_SHORT).show()
            }else{
                Picasso.get().load(Url.url_img_produk+it.data!!.shoes_foto).into(imageViewDetProduct)
                textViewDetProductName.text = it.data.shoes_name
                textViewDetProductDesc.text = it.data.shoes_desc
                textViewDetProductPrice.text = it.data.shoes_price
            }
        })
        detProductViewModel.getProductData(id)
    }

    override fun onItemDetailClick(sizeShoes: SizeShoes) {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }
}