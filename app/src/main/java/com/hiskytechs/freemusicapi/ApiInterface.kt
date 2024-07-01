package com.hiskytechs.freemusicapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("x-rapidapi-key:de0837890amsh897527631ca4f80p1ceb81jsn830d10f20995","x-rapidapi-host:deezerdevs-deezer.p.rapidapi.com" )
@GET("search")
    fun getData(@Query("q") query: String): Call<MyData>

}