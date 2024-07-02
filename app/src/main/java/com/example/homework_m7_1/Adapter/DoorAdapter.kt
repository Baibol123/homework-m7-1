package com.example.homework_m7_1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_m7_1.R
import com.example.homework_m7_1.data.Door
import com.example.homework_m7_1.databinding.ItemDoorBinding

class DoorAdapter(private var doors: List<Door>) : RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {

    class DoorViewHolder(private val binding: ItemDoorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(door: Door) {
            binding.tvDoorName.text = door.name
            // Load image into binding.imgDoor using an image loading library such as Glide or Picasso if applicable
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        val binding = ItemDoorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.bind(doors[position])
    }

    override fun getItemCount(): Int = doors.size

    // Public method to update doors list
    fun updateDoors(newDoors: List<Door>) {
        this.doors = newDoors
        notifyDataSetChanged()
    }
}