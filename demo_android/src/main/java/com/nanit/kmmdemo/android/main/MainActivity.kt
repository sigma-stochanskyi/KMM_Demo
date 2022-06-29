package com.nanit.kmmdemo.android.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.nanit.kmmdemo.android.R

fun greet(): String {
    return "Hola"
}

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels<MainViewModel> { MainViewModel.Factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeModel()
    }

    private fun observeModel() {
        viewModel.titleLiveData.observe(this) {
            val tv: TextView = findViewById(R.id.text_view)
            tv.text = it
        }
    }
}
