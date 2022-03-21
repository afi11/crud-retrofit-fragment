package com.example.shoesstore.models

data class ProductList(val data: List<Product>)
data class Product(val id: String?,
                   val shoes_name: String?, val shoes_price: String?,
                   val shoes_desc: String?,
                   val brand_id: String?, val kategori_id: String?,
                   val created_at: String?, val updated_at: String?,
                   val shoes_foto: String?, val brand_name: String?,
                   val kategori_nama: String?)
data class ProductResponse(val code: Int?, val meta: String?, val data: Product?)