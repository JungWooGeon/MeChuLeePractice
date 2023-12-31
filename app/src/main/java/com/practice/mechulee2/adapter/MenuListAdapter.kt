package com.practice.mechulee2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.practice.mechulee2.MenuInfo
import com.practice.mechulee2.R

class MenuListAdapter : RecyclerView.Adapter<MenuListAdapter.MyViewHolder>(){

    var list = ArrayList<MenuInfo>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var menuTitleTextView: AppCompatTextView = itemView.findViewById(R.id.menuTitle)
        var menuDetailTextView: AppCompatTextView = itemView.findViewById(R.id.menuDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_menu_list, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.menuTitleTextView.text = list[position].title
        holder.menuDetailTextView.text = list[position].detail

        // recyclerview animation 효과 추가
        val animation: Animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slide_in_row)
        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}