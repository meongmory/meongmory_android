package com.meongmoryteam.presentation.ui.map

import android.os.Bundle
import com.meongmoryteam.presentation.base.BaseAppCompatActivity
import com.meongmoryteam.presentation.databinding.ActivityMapBinding
import dagger.hilt.android.AndroidEntryPoint

class MapActivity : BaseAppCompatActivity() {
    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}