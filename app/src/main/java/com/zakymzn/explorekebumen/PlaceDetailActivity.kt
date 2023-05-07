package com.zakymzn.explorekebumen

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import com.zakymzn.explorekebumen.databinding.ActivityPlaceDetailBinding

class PlaceDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.title = intent.getStringExtra("place_name")
        binding.placeDetailPhoto.setImageResource(intent.getIntExtra("place_photo", -1))
        binding.placeDetailLocation.text = intent.getStringExtra("place_location")
        binding.placeDetailDescription.text = intent.getStringExtra("place_description")

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}