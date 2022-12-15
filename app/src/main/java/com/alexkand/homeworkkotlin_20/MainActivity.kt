package com.alexkand.homeworkkotlin_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment()).commit()
        //https://www.fishwatch.gov/api/species
        //https://dog.ceo/api/breeds/image/random
    }
}