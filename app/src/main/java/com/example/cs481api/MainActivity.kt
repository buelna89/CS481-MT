package com.example.cs481api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cs481api.databinding.ActivityMainBinding
import com.example.cs481api.fragments.display
import com.example.cs481api.fragments.api

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(api())

        binding.bottomnav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.display -> replaceFragment(display())
                R.id.api -> replaceFragment(api())
                //R.id.settings -> replaceFragment(Settings())

                else ->{

                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout2,fragment)
        fragmentTransaction.commit()


    }
}