package com.example.lab_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lab_3.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
    }

   fun loadImage(){
       Glide.with(binding.root)
           .load("https://i.pinimg.com/564x/5e/27/2f/5e272f01b4e83b42c5a8d31e9b0e96b1.jpg")
         .centerCrop()
           .placeholder(binding.imageView.drawable)
           .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(binding.imageView)
   }
}