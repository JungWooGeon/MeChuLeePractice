package com.practice.mechulee2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.practice.mechulee2.R

class MenuCategoryAdapter : RecyclerView.Adapter<MenuCategoryAdapter.MyViewHolder>() {

    val list = ArrayList<String>()
    var currentClickIdx = 0

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryButton: AppCompatButton = itemView.findViewById(R.id.categoryButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_menu_category, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.categoryButton.text = list[position]

        if (position == currentClickIdx) {
            holder.categoryButton.setBackgroundResource(R.drawable.clicked_button)
            holder.categoryButton.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        } else {
            holder.categoryButton.setBackgroundResource(R.drawable.unclicked_button)
            holder.categoryButton.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.defaultColor))
        }

        holder.categoryButton.setOnClickListener {
            notifyItemChanged(currentClickIdx)
            currentClickIdx = position
            notifyItemChanged(currentClickIdx)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}