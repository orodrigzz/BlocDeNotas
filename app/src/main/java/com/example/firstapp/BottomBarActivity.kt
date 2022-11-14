package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.ActivityBottomBarBinding

class BottomBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        binding.bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId){
                R.id.firstButton -> setFragment(firstFragment)
                R.id.secondButton -> setFragment(secondFragment)
            }
            true
        }
    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, fragment)
            commit()
        }
    }

}