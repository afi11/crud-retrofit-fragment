package com.example.shoesstore.models

data class SizeShoesList(val data: List<SizeShoes>)
data class SizeShoes(val id: String?, val shoes_id: String?, val shoe_size: String, val shoe_stock: String)
data class SizeShoesResponse(val code: Int?, val meta: String?, val data: SizeShoes?)