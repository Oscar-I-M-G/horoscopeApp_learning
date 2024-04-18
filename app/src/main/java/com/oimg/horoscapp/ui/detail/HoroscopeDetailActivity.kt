package com.oimg.horoscapp.ui.detail

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.oimg.horoscapp.R
import com.oimg.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    //agregamos el viewModel
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
    }
}