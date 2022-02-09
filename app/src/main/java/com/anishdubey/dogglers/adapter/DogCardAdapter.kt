package com.anishdubey.dogglers.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anishdubey.dogglers.const.Layout
import com.anishdubey.dogglers.databinding.GridItemViewBinding
import com.anishdubey.dogglers.databinding.VerticalHorizontalItemViewBinding
import com.anishdubey.dogglers.model.Dog

/**
 * Adapter to handle multiple views type
 */
class DogCardAdapter(
    private val context: Context,
    private val layout: Int,
    private val dataSet: List<Dog>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Layout.HORIZONTAL || viewType == Layout.VERTICAL) {
            val binding = VerticalHorizontalItemViewBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
            DogCardViewHolder(binding)
        } else {
            val binding = GridItemViewBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
            DogCardViewHolderGrid(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataSet[position]
        if (holder.itemViewType == Layout.HORIZONTAL || holder.itemViewType == Layout.VERTICAL) {
            (holder as DogCardViewHolder).bind(item)
        } else {
            (holder as DogCardViewHolderGrid).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    // return view type to ViewHolder
    override fun getItemViewType(position: Int): Int {
        return layout
    }

    // Binder Class of Vertical and Horizontal Views
    class DogCardViewHolder(
        private val binding: VerticalHorizontalItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Dog) {
            binding.imageView.setImageResource(item.imageResourceId)
            binding.nameTextView.text = item.name
            binding.ageTextView.text = "Age: ${item.age}"
            binding.hobbiesTextView.text = "Hobbies: ${item.hobbies}"
        }
    }

    // Binder Class of Gird View
    class DogCardViewHolderGrid(
        private val binding: GridItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Dog) {
            binding.imageView.setImageResource(item.imageResourceId)
            binding.nameTextView.text = item.name
            binding.ageTextView.text = "Age: ${item.age}"
            binding.hobbiesTextView.text = "Hobbies: ${item.hobbies}"
        }
    }

}