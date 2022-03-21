package com.example.shoesstore.instances

import com.example.shoesstore.utils.Url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShoesInstance {

    companion object {

        fun getShoesInstance() : Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(Url.url_api)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

}