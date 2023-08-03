package com.practice.mechulee2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.mechulee2.adapter.MenuGridAdapter
import com.practice.mechulee2.databinding.FragmentMenuGridBinding

class MenuGridFragment(private val menuList: ArrayList<MenuInfo>) : Fragment() {

    private var _binding: FragmentMenuGridBinding? = null
    private val binding get() = _binding!!

    private val menuGridRecyclerViewAdapter = MenuGridAdapter()

    @SuppressLint("NotifyDataSetChanged")
    fun updateMenuList(menuList: ArrayList<MenuInfo>) {
        menuGridRecyclerViewAdapter.list = menuList
        menuGridRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuGridBinding.inflate(layoutInflater)

        initRecyclerView()
        updateMenuList(menuList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        // 메뉴 그리드 RecyclerView
        binding.menuGridRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = menuGridRecyclerViewAdapter
        }
    }
}