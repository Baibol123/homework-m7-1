package com.example.homework_m7_1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_m7_1.R
import com.example.homework_m7_1.data.Camera
import com.example.homework_m7_1.databinding.ItemCameraBinding

class CameraAdapter(private var cameras: List<Camera>) : RecyclerView.Adapter<CameraAdapter.CameraViewHolder>() {

    class CameraViewHolder(private val binding: ItemCameraBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(camera: Camera) {
            binding.tvCamName.text = camera.name
            // Load image into binding.imgCamer using an image loading library such as Glide or Picasso
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        val binding = ItemCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CameraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount(): Int = cameras.size

    // Public method to update cameras list
    fun updateCameras(newCameras: List<Camera>) {
        this.cameras = newCameras
        notifyDataSetChanged()
    }
}