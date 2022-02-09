package com.anishdubey.dogglers.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anishdubey.dogglers.const.Layout
import com.anishdubey.dogglers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // handle button clicks
        setButtonClicks()

    }

    private fun setButtonClicks() {

        binding.verticalLayout.setOnClickListener {
            val intent: Intent = Intent(this, Dogglers::class.java)
            intent.putExtra("layout", Layout.VERTICAL)
            startActivity(intent)
        }

        binding.horizontalLayout.setOnClickListener {
            val intent: Intent = Intent(this, Dogglers::class.java)
            intent.putExtra("layout", Layout.HORIZONTAL)
            startActivity(intent)
        }

        binding.gridLayout.setOnClickListener {
            val intent: Intent = Intent(this, Dogglers::class.java)
            intent.putExtra("layout", Layout.GRID)
            startActivity(intent)
        }
    }
}