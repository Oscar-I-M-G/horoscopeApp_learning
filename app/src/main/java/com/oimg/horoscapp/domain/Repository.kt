package com.oimg.horoscapp.domain

import com.oimg.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}