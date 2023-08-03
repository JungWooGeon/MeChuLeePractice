package com.practice.mechulee2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mechulee2.adapter.MenuListAdapter
import com.practice.mechulee2.databinding.FragmentMenuListBinding

class MenuListFragment : Fragment() {
    private var _binding: FragmentMenuListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuListBinding.inflate(layoutInflater)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        // 메뉴 리스트 RecyclerView
        val menuListRecyclerViewAdapter = MenuListAdapter()

        val menuList = ArrayList<MenuInfo>().apply {
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
            add(MenuInfo("된장찌개", "김치, 두부, 파, 양파, 고추"))
        }

        menuList.forEach { menuListRecyclerViewAdapter.list.add(it) }

        binding.menuListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = menuListRecyclerViewAdapter
        }
    }
}