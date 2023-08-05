package com.example.viewpager2geo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager2geo.databinding.ActivityMainBinding
import com.example.viewpager2payme.Adapter.User
import com.example.viewpager2payme.Adapters.ViewPager2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ViewPager2Adapter
    lateinit var list: ArrayList<User>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        adapter = ViewPager2Adapter(list)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){ _,_->

        }.attach()
        binding.btnNext.setOnClickListener {
            binding.tabLayout.selectTab(binding.tabLayout.getTabAt(list.size-1))
        }

        binding.tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0){
                    binding.btnNext.text = ""
                }else{
                    binding.btnNext.text = "O'tkazib yuborish"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

    private fun loadData() {
        list = ArrayList()
        list.add(User(R.drawable.img,"GeoAxborot","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_1,"Huquqiy axborot","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_2,"To'lov xizmatlari","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_3,"Qo'shimcha imkoniyatlar","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))

    }
}