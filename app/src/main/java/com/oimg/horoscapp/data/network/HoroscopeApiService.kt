package com.oimg.horoscapp.data.network

import com.oimg.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
    @GET("/{sign}")
    //corutinas con el suspend
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse
}