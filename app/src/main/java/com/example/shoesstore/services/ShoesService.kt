package com.example.shoesstore.services

import com.example.shoesstore.models.BrandList
import com.example.shoesstore.models.ProductList
import com.example.shoesstore.models.ProductResponse
import com.example.shoesstore.models.SizeShoesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ShoesService {

    // Brands
    @GET("brands")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4Ljc4LjYwXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjMxNTM3NTU3LCJuYmYiOjE2MzE1Mzc1NTcsImp0aSI6IlJIR25DZXd3c2xkUGFpc1QiLCJzdWIiOjEsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.hseS8qqiYyG95UqZ3Nwij8atoW0P8rJ7lecwEIGbhiE")
    fun getBrands(): Call<BrandList>

    // Products
    @GET("shoes")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4Ljc4LjYwXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjMxNTM3NTU3LCJuYmYiOjE2MzE1Mzc1NTcsImp0aSI6IlJIR25DZXd3c2xkUGFpc1QiLCJzdWIiOjEsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.hseS8qqiYyG95UqZ3Nwij8atoW0P8rJ7lecwEIGbhiE")
    fun getProducts(): Call<ProductList>

    @GET("shoes/{id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4Ljc4LjYwXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjMxNTM3NTU3LCJuYmYiOjE2MzE1Mzc1NTcsImp0aSI6IlJIR25DZXd3c2xkUGFpc1QiLCJzdWIiOjEsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.hseS8qqiYyG95UqZ3Nwij8atoW0P8rJ7lecwEIGbhiE")
    fun getDetProducts(@Path("id") id: String): Call<ProductResponse>

    @GET("size_shoes/{id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4Ljc4LjYwXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjMxNTM3NTU3LCJuYmYiOjE2MzE1Mzc1NTcsImp0aSI6IlJIR25DZXd3c2xkUGFpc1QiLCJzdWIiOjEsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.hseS8qqiYyG95UqZ3Nwij8atoW0P8rJ7lecwEIGbhiE")
    fun getSizeProduct(@Path("id") id: String): Call<SizeShoesResponse>
}