package net.uniquecomputer.houseguru

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import net.uniquecomputer.houseguru.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> {
                    replaceFragment(Home())
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.Service -> {
                    replaceFragment(Service())
                }
                R.id.Wallet -> {
                    replaceFragment(Wallet())
                }
                R.id.Booking -> {
                    replaceFragment(Booking())
                }

                else -> {

                }


            }
            true


        }



    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }



}