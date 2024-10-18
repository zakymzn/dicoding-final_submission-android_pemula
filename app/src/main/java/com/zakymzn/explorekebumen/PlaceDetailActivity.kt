package com.zakymzn.explorekebumen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        binding.actionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, intent.getStringExtra("place_description"))
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}