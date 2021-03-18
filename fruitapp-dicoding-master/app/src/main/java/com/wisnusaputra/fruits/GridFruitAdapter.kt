package com.wisnusaputra.fruits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridFruitAdapter(val listFruit: ArrayList<Fruit>) :
    RecyclerView.Adapter<GridFruitAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_fruit, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listFruit[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFruit[holder.adapterPosition]) }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Fruit)
    }
}