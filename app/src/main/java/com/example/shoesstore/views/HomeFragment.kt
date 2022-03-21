package com.example.shoesstore.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoesstore.MainActivity
import com.example.shoesstore.R
import com.example.shoesstore.adapters.BrandRecyclerView
import com.example.shoesstore.adapters.ProdukRecyclerView
import com.example.shoesstore.models.BrandList
import com.example.shoesstore.models.Product
import com.example.shoesstore.models.ProductList
import com.example.shoesstore.viewmodels.HomeViewModel
import com.example.shoesstore.views.product.DetProductActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), ProdukRecyclerView.OnItemClickListener {

    lateinit var thisParent : MainActivity
    lateinit var v : View
    lateinit var brandRecyclerView: BrandRecyclerView
    lateinit var produkRecyclerView: ProdukRecyclerView
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        brandRecyclerView = BrandRecyclerView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisParent = activity as MainActivity

        v = inflater.inflate(R.layout.fragment_home, container, false)

        initViewModel()
        initRecyclerView()

        return v
    }

    private fun initRecyclerView() {
        v.recycler_brand.apply {
            layoutManager = LinearLayoutManager(thisParent, LinearLayoutManager.HORIZONTAL, false)
            brandRecyclerView = BrandRecyclerView()
            adapter = brandRecyclerView
        }
        v.recycler_produk.apply {
            layoutManager = GridLayoutManager(thisParent, 2)
            produkRecyclerView = ProdukRecyclerView(this@HomeFragment)
            adapter = produkRecyclerView
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(thisParent).get(HomeViewModel::class.java)
        // Brands
        viewModel.getBrandListObserveable().observe(thisParent, Observer<BrandList>{
            if(it == null){
                Toast.makeText(thisParent, "no result found",Toast.LENGTH_SHORT).show()
            }else{
                v.progressBrand.visibility = View.GONE
                brandRecyclerView.brandList = it.data.toMutableList()
                brandRecyclerView.notifyDataSetChanged()
            }
        })
        viewModel.getBrandsList()

        // Products
        viewModel.getProductListObserveable().observe(thisParent, Observer<ProductList>{
            if(it != null){
                v.progressProducts.visibility = View.GONE
                produkRecyclerView.produkList = it.data.toMutableList()
                produkRecyclerView.notifyDataSetChanged()
            }
        })
        viewModel.getProductList()
    }

    companion object {
        fun newInstance() : HomeFragment{
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onItemDetailClick(product: Product) {
        val intent = Intent(thisParent, DetProductActivity::class.java)
        intent.putExtra("productId", product.id)
        startActivity(intent)
    }

}