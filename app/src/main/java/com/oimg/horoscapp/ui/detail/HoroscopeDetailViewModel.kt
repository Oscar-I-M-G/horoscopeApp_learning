package com.oimg.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oimg.horoscapp.domain.model.HoroscopeModel
import com.oimg.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
// Inyectar cassos de usos
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel
    fun getHoroscope(sign:HoroscopeModel){
        // hilo especial para operaciones lentas
        horoscope = sign
        viewModelScope.launch{
            //  hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){ getPredictionUseCase(sign.name) } // hilo secundario
            if (result != null){
                _state.value = HoroscopeDetailState.Success(result.horoscope,result.sign, horoscope)
            }else{
                _state.value = HoroscopeDetailState.Error("La has cagado chaval pide ayuda")
            }
        // hilo principal
        }
    }

}