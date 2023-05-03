package com.zakymzn.explorekebumen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakymzn.explorekebumen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Place>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPlaces.setHasFixedSize(true)

        list.addAll(getListPlaces())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPlaces(): ArrayList<Place> {
        val placeName = resources.getStringArray(R.array.place_name)
        val placeLocation = resources.getStringArray(R.array.place_location)
        val placeMainPhoto = resources.obtainTypedArray(R.array.place_main_photo)
        val listPlace = ArrayList<Place>()
        for (i in placeName.indices) {
            val place = Place(placeName[i], placeLocation[i], placeMainPhoto.getResourceId(i, -1))
            listPlace.add(place)
        }
        return listPlace
    }

    private fun showRecyclerList() {
        binding.rvPlaces.layoutManager = LinearLayoutManager(this)
        val listPlaceAdapter = ListPlaceAdapter(list)
        binding.rvPlaces.adapter = listPlaceAdapter

        listPlaceAdapter.setOnItemClickCallback(object : ListPlaceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Place) {
                showSelectedPlace(data)
            }
        })
    }

    private fun showSelectedPlace(place: Place) {
        Toast.makeText(this, "Kamu memilih " + place.name, Toast.LENGTH_SHORT).show()
    }
}