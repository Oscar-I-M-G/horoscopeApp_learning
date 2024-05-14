package com.oimg.horoscapp.ui.detail

import com.oimg.horoscapp.domain.model.HoroscopeModel

// pagina de estados
sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}