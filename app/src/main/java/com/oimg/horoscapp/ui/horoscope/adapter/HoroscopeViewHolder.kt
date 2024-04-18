package com.oimg.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.oimg.horoscapp.databinding.ItemHoroscopeBinding
import com.oimg.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        binding.ivHoroscope.setImageResource(horoscopeInfo. img)
        val context = binding.tvHoroscope.context
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, newLambda={onItemSelected(horoscopeInfo)})
            //onItemSelected(horoscopeInfo)
            //lansar animacion
        }
    }

    //animacion
    private fun startRotationAnimation(view: View,newLambda:()->Unit){
        view.animate().apply {
            // animaciones en milisegundos
            duration = 500
            interpolator = LinearInterpolator()
            //otra animacion rapida
            rotationBy(360f)
            //lambdda function
            withEndAction {  newLambda()}
            start()
        }
    }
}