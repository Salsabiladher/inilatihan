package com.wisnusaputra.fruits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMentorAdapter(private val listMentor: ArrayList<Mentor>) :
    RecyclerView.Adapter<ListMentorAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        i: Int
    ): ListMentorAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_mentor, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMentor.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (jenis, detail, layanan, photo) = listMentor[position]

        Glide.with(holder.itemView.context)
            .load(listMentor[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvJenis.text = jenis
        holder.tvDetail.text = detail
        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listMentor[holder.adapterPosition]) }
        holder.preview.setOnClickListener{onItemClickCallback.onItemClicked(listMentor[holder.adapterPosition])}
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJenis: TextView = itemView.findViewById(R.id.tv_item_jenis)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_mentor)
        var preview: Button = itemView.findViewById(R.id.preview)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Mentor)
    }
}