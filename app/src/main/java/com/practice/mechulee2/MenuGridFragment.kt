package com.practice.mechulee2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.mechulee2.adapter.MenuGridAdapter
import com.practice.mechulee2.databinding.FragmentMenuGridBinding

class MenuGridFragment : Fragment() {

    private var _binding: FragmentMenuGridBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuGridBinding.inflate(layoutInflater)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        // 메뉴 그리드 RecyclerView
        val menuGridRecyclerViewAdapter = MenuGridAdapter()

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

        menuList.forEach { menuGridRecyclerViewAdapter.list.add(it) }

        binding.menuGridRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), 3)
            adapter = menuGridRecyclerViewAdapter
        }
    }
}