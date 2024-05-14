package com.oimg.horoscapp.data

import android.util.Log
import com.oimg.horoscapp.data.network.HoroscopeApiService
import com.oimg.horoscapp.domain.Repository
import com.oimg.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopeApiService):Repository{
    override suspend fun getPrediction(sign: String): PredictionModel? { //mandamos
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() } // hay que mapearlo
            .onFailure { Log.i("Ivan","Ha ocurrido un gran error ${it.message}") }
        return null
    }

}