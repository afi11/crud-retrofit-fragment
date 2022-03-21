package com.example.shoesstore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesstore.instances.ShoesInstance
import com.example.shoesstore.models.BrandList
import com.example.shoesstore.models.ProductList
import com.example.shoesstore.services.ShoesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HomeViewModel: ViewModel() {

    lateinit var recyclerListBrands: MutableLiveData<BrandList>
    lateinit var recyclerListProducts: MutableLiveData<ProductList>

    init {
        recyclerListBrands = MutableLiveData()
        recyclerListProducts = MutableLiveData()
    }

    fun getProductListObserveable(): MutableLiveData<ProductList> {
        return recyclerListProducts
    }

    fun getBrandListObserveable(): MutableLiveData<BrandList> {
        return recyclerListBrands
    }

    fun getProductList() {
        val shoesInstance = ShoesInstance.getShoesInstance().create(ShoesService::class.java)
        val call = shoesInstance.getProducts()
        call.enqueue(object : Callback<ProductList>{
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if(response.isSuccessful) {
                    recyclerListProducts.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                recyclerListProducts.postValue(null)
            }

        })
    }

    fun getBrandsList() {
        val shoesInstance = ShoesInstance.getShoesInstance().create(ShoesService::class.java)
        val call = shoesInstance.getBrands()
        call.enqueue(object : Callback<BrandList>{
            override fun onResponse(call: Call<BrandList>, response: Response<BrandList>) {
                if(response.isSuccessful){
                    recyclerListBrands.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<BrandList>, t: Throwable) {
                recyclerListBrands.postValue(null)
            }

        })
    }

}