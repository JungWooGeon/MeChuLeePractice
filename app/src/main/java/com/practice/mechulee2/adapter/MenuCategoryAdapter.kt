package com.practice.mechulee2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.practice.mechulee2.R

class MenuCategoryAdapter : RecyclerView.Adapter<MenuCategoryAdapter.MyViewHolder>() {

    val list = ArrayList<String>()

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
    }

    override fun getItemCount(): Int {
        return list.size
    }
}