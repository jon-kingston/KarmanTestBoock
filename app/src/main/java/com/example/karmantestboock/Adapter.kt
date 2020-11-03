package com.example.karmantestboock

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karmantestboock.databinding.ItemElemBinding
import com.google.gson.Gson

class Adapter(
    val ctx: Context,
    val list: List<Cover>
): RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(ItemElemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = list.size

    inner class Holder(private val view: ItemElemBinding): RecyclerView.ViewHolder(view.root) {


        fun bind(position: Int) {
            Glide.with(ctx)
                .load(list[position].image)
                .into(view.imageView2)
            view.textView2.text = list[position].title

            view.root.setOnClickListener {
                ctx.startActivity(Intent(ctx, DetailsActivity::class.java).apply {
                    putExtra("cover", Gson().toJson(list[position]))
                })
            }
        }

    }

}
