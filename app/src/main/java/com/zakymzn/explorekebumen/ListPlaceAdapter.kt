package com.zakymzn.explorekebumen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakymzn.explorekebumen.databinding.ItemPlaceBinding

class ListPlaceAdapter(private val listPlace: ArrayList<Place>) : RecyclerView.Adapter<ListPlaceAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listPlace.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, location, photo) = listPlace[position]
        holder.binding.imgPlacePhoto.setImageResource(photo)
        holder.binding.tvPlaceName.text = name
        holder.binding.tvPlaceLocation.text = location
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPlace[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Place)
    }
}