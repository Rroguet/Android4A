package com.esiea.android4a.data.remote

import com.esiea.android4a.data.repository.RestGalaxiesResponse
import retrofit2.Call
import retrofit2.http.GET

interface GalaxieAPI {
    @get:GET("galaxies.json")
    val galaxieResponse: Call<RestGalaxiesResponse>
}