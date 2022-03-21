package com.example.shoesstore.models

data class BrandList(val data: List<Brand>)
data class Brand(val id: String?, val brand_name: String?, val brand_photo: String?)
data class BrandResponse(val code: Int?, val meta: String?, val data: Brand?)