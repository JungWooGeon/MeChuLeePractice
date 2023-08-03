package com.practice.mechulee2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mechulee2.adapter.MenuCategoryAdapter
import com.practice.mechulee2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val FRAGMENT_TAG_MENU_LIST = "MenuList"
        private const val FRAGMENT_TAG_MENU_GRID = "MenuGrid"
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.menuList.observe(this) { menuList ->
            // menuList 정보 변경 감지 시 RecyclerView 갱신
            val menuListFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG_MENU_LIST) as? MenuListFragment
            val menuGridFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG_MENU_GRID) as? MenuGridFragment

            menuListFragment?.updateMenuList(menuList)
            menuGridFragment?.updateMenuList(menuList)
        }

        initRecyclerView()
        initFragmentContainer(savedInstanceState)
        initButton()
        initEditText()

        // StatusBar 색 변경
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }

    private fun initRecyclerView() {
        // 메뉴 카테고리 RecyclerView 초기화
        val menuCategoryRecyclerViewAdapter = MenuCategoryAdapter()

        viewModel.categoryList.value?.forEach { menuCategoryRecyclerViewAdapter.list.add(it) }

        binding.menuCategoryRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuCategoryRecyclerViewAdapter
        }
    }

    // 처음 FragmentContainer 셋팅 -> '리스트' RecyclerView Fragment 가 보이게 설정
    private fun initFragmentContainer(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainer, MenuListFragment(viewModel.menuList.value ?: arrayListOf()), FRAGMENT_TAG_MENU_LIST)
            }
        }
    }

    private fun initButton() {
        // '리스트' 아이콘 클릭 시 -> Fragment 전환
        binding.menuListImageIcon.setOnClickListener {
            switchFragment(FRAGMENT_TAG_MENU_GRID, FRAGMENT_TAG_MENU_LIST) {
                MenuListFragment(viewModel.menuList.value ?: arrayListOf())
            }
        }

        // '그리드' 아이콘 클릭 시 -> Fragment 전환
        binding.menuListGridIcon.setOnClickListener {
            switchFragment(FRAGMENT_TAG_MENU_LIST, FRAGMENT_TAG_MENU_GRID) {
                MenuGridFragment(viewModel.menuList.value ?: arrayListOf())
            }
        }
    }

    private fun initEditText() {
        // 검색창 입력 시마다 검색 기능 수행
        binding.menuSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.searchMenuList(binding.menuSearchEditText.text.toString())
            }
        })
        binding.menuSearchEditText.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                // 키보드 내리기
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.menuSearchEditText.windowToken, 0)
                handled = true
            }
            handled
        }
    }

    // Fragment 전환 기능 ('리스트', '그리드' 버튼 클릭 시마다 사용)
    private fun switchFragment(fromTag: String, toTag: String, newFragment: () -> Fragment) {
        val fromFragment: Fragment? = supportFragmentManager.findFragmentByTag(fromTag)
        val toFragment: Fragment? = supportFragmentManager.findFragmentByTag(toTag)

        supportFragmentManager.commit {
            fromFragment?.let { this.remove(it) }
            if (toFragment == null) {
                this.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                this.add(R.id.fragmentContainer, newFragment(), toTag)
            } else {
                this.replace(R.id.fragmentContainer, toFragment)
            }
        }
    }
}