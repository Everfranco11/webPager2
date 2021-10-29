package com.py.webpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.py.webpager2.`class`.Parcela
import com.py.webpager2.adapter.ViewPagerAdapter
import com.py.webpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewPagerAdapter = ViewPagerAdapter()
        val myList: java.util.ArrayList<Parcela> = arrayListOf()
        val p1 = Parcela(1, "test 1")
        val p2 = Parcela(2, "test 2")
        val p3 = Parcela(3, "test 3")
        myList.add(p1)
        myList.add(p2)
        myList.add(p3)
        viewPagerAdapter.setData(myList)
        binding.viewPager2.adapter = viewPagerAdapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicator.setViewPager(binding.viewPager2)

    }
}