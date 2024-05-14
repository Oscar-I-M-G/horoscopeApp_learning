package com.oimg.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.oimg.horoscapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date:String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    } // puedo manipular que le puedo mandar a cada unooooooooo ahuevoooooo
}