package com.esiea.android4a

import com.esiea.android4a.data.remote.GalaxieAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Singletons {
    private var gsonInstance: Gson? = null
    private var galaxieApiInstance: GalaxieAPI? = null

    val gson:Gson?
        get() {
            if (gsonInstance == null)
            {
                gsonInstance = GsonBuilder()
                    .setLenient()
                    .create()
            }
            return gsonInstance
        }

    val galaxieAPI:GalaxieAPI?
        get() {
            if (galaxieApiInstance == null)
            {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                galaxieApiInstance = retrofit.create(GalaxieAPI::class.java)
            }
            return galaxieApiInstance
        }
}