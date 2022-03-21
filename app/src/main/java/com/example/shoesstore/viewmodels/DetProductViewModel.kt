package com.example.shoesstore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesstore.instances.ShoesInstance
import com.example.shoesstore.models.ProductResponse
import com.example.shoesstore.models.SizeShoesResponse
import com.example.shoesstore.services.ShoesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetProductViewModel : ViewModel() {

    lateinit var loadDetProduct : MutableLiveData<ProductResponse?>
    lateinit var loadSizeProduct : MutableLiveData<SizeShoesResponse?>

    init {
        loadDetProduct = MutableLiveData()
        loadSizeProduct = MutableLiveData()
    }

    fun getSizeProductObserveable() : MutableLiveData<SizeShoesResponse?> {
        return loadSizeProduct
    }

    fun getDetProductObserveable() : MutableLiveData<ProductResponse?> {
        return loadDetProduct
    }

    fun getSizeProduct(id: String?) {
        val retroInstance = ShoesInstance.getShoesInstance().create(ShoesService::class.java)
        val call = retroInstance.getSizeProduct(id!!)
        call.enqueue(object : Callback<SizeShoesResponse?>{
            override fun onResponse(
                call: Call<SizeShoesResponse?>,
                response: Response<SizeShoesResponse?>
            ) {
                if(response.isSuccessful){
                    loadSizeProduct.postValue(response.body())
                }else{
                    loadSizeProduct.postValue(null)
                }
            }

            override fun onFailure(call: Call<SizeShoesResponse?>, t: Throwable) {
                loadSizeProduct.postValue(null)
            }

        })
    }

    fun getProductData(id: String?) {
        val retroInstance = ShoesInstance.getShoesInstance().create(ShoesService::class.java)
        val call = retroInstance.getDetProducts(id!!)
        call.enqueue(object : Callback<ProductResponse?>{
            override fun onResponse(
                call: Call<ProductResponse?>,
                response: Response<ProductResponse?>
            ) {
                if(response.isSuccessful){
                    loadDetProduct.postValue(response.body())
                }else{
                    loadDetProduct.postValue(null)
                }
            }

            override fun onFailure(call: Call<ProductResponse?>, t: Throwable) {
                loadDetProduct.postValue(null)
            }

        })
    }

}