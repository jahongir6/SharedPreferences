package com.example.sharedandswitch

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedandswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//bu yerda button bosilganda ikkinchi oynaga otsin
        MyShared.init(this)
        binding.btnKirish.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
      //bu yerda color true bolsa shu rang va false bolsa shu rang chiqsin didim
        if (MyShared.color) {
            binding.root.setBackgroundColor(Color.GRAY)
        } else {
            binding.root.setBackgroundColor(Color.RED)
        }
    }
}