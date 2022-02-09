package com.anishdubey.dogglers.ui

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anishdubey.dogglers.adapter.DogCardAdapter
import com.anishdubey.dogglers.const.Layout
import com.anishdubey.dogglers.data.Datasource
import com.anishdubey.dogglers.databinding.ActivityDogglersBinding
import com.anishdubey.dogglers.model.Dog

class Dogglers : AppCompatActivity() {
    private lateinit var binding: ActivityDogglersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogglersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get layout type from intent
        val layoutType: Int = intent.getIntExtra("layout", 1)
        // get and shuffle the static data
        val dataSet: List<Dog> =
            Datasource.getData()
        //.shuffled(random = Random())

        // pass data to adapter
        setLayoutOnBasisOfSelection(layoutType, dataSet)
    }

    private fun setLayoutOnBasisOfSelection(layoutType: Int, dataSet: List<Dog>) {
        // set properties of respective layout on basis of user selection
        when (layoutType) {
            Layout.VERTICAL -> {
                binding.recyclerView.adapter = DogCardAdapter(this, layoutType, dataSet)
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
                binding.recyclerView.setHasFixedSize(true)
            }
            Layout.HORIZONTAL -> {
                binding.recyclerView.layoutParams = getLayoutParams()
                binding.recyclerView.adapter = DogCardAdapter(this, layoutType, dataSet)
                binding.recyclerView.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                binding.recyclerView.setHasFixedSize(true)
            }
            Layout.GRID -> {
                binding.recyclerView.adapter = DogCardAdapter(this, layoutType, dataSet)
                binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
                binding.recyclerView.setHasFixedSize(true)
            }
        }
    }

    /**
     * Layout params for Horizontal RecyclerView
     */
    private fun getLayoutParams(): FrameLayout.LayoutParams {
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER
        }
        return params
    }
}