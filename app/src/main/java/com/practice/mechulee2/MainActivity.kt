package com.practice.mechulee2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mechulee2.adapter.MenuCategoryAdapter
import com.practice.mechulee2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initFragmentContainer(savedInstanceState)
        initButton()

        // StatusBar 색 변경
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }

    private fun initRecyclerView() {
        // 메뉴 카테고리 RecyclerView init
        val menuCategoryRecyclerViewAdapter = MenuCategoryAdapter()

        val categoryList = ArrayList<String>().apply {
            add("전체")
            add("한식")
            add("중식")
            add("일식")
            add("양식")
            add("분식")
            add("아시안")
        }

        categoryList.forEach { menuCategoryRecyclerViewAdapter.list.add(it) }

        binding.menuCategoryRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuCategoryRecyclerViewAdapter
        }
    }

    private fun initFragmentContainer(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainer, MenuListFragment(), "MenuList")
            }
        }
    }

    private fun initButton() {
        // 메뉴 리스트 아이콘 클릭 이벤트 -> Fragment Transaction
        binding.menuListImageIcon.setOnClickListener {
            val menuListFragment: Fragment? = supportFragmentManager.findFragmentByTag("MenuList")
            val menuGridFragment: Fragment? = supportFragmentManager.findFragmentByTag("MenuGrid")
            supportFragmentManager.commit {
                if (menuListFragment != null) this.remove(menuListFragment)

                if (menuGridFragment != null) {
                    this.remove(menuGridFragment)
                    this.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    this.add(R.id.fragmentContainer, MenuListFragment(), "MenuList")
                    this.addToBackStack(null)
                }
            }
        }

        // 메뉴 그리드 아이콘 클릭 이벤트 -> Fragment Transaction
        binding.menuListGridIcon.setOnClickListener {
            val menuListFragment: Fragment? = supportFragmentManager.findFragmentByTag("MenuList")
            val menuGridFragment: Fragment? = supportFragmentManager.findFragmentByTag("MenuGrid")
            supportFragmentManager.commit {
                if (menuGridFragment != null) this.remove(menuGridFragment)

                if (menuListFragment != null) {
                    this.remove(menuListFragment)
                    this.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    this.add(R.id.fragmentContainer, MenuGridFragment(), "MenuGrid")
                    this.addToBackStack(null)
                }
            }
        }
    }
}