package com.practice.mechulee2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mechulee2.adapter.MenuListAdapter
import com.practice.mechulee2.databinding.FragmentMenuListBinding

class MenuListFragment(private val menuList: ArrayList<MenuInfo>) : Fragment() {

    private var _binding: FragmentMenuListBinding? = null
    private val binding get() = _binding!!

    private val menuListRecyclerViewAdapter = MenuListAdapter()

    @SuppressLint("NotifyDataSetChanged")
    fun updateMenuList(menuList: ArrayList<MenuInfo>) {
        menuListRecyclerViewAdapter.list = menuList
        menuListRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuListBinding.inflate(layoutInflater)

        initRecyclerView()
        updateMenuList(menuList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        // 메뉴 리스트 RecyclerView
        binding.menuListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = menuListRecyclerViewAdapter
        }
    }
}