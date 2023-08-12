package com.example.sharedandswitch

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.sharedandswitch.databinding.ActivityMain2Binding

//keshga yozish
//get keshda  oqib qaytib berai
//set keshga yozadi
class MainActivity2 : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MyShared.init(this)

        //bu svitchni listeneri
        binding.switc.setOnCheckedChangeListener { buttonView, b ->
            MyShared.color = b//bu yerda b switchni bosilgan yoki
            // bosilmaganiniaytib turadi true bolsa mysharedni colorga true ni tenglab qoyadi

        }
        if (MyShared.color == true) {
            binding.switc.isChecked = true
        } else {
            binding.switc.isChecked = false
        }

    }

}