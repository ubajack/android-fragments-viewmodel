package com.ubalia.fragment.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.ubalia.fragment.navigation.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var randomNumber = 0
    private val viewModel: RandomViewModel by viewModels()

    fun generateRandomNumber(from: Int, until: Int): Int = Random.nextInt(from, until)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGoToActivity.setOnClickListener {
            // val intent = Intent(this, SecondActivity::class.java)
            // startActivity(intent)
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRandom.setOnClickListener {
            randomNumber = generateRandomNumber(0, 100)
            viewModel.setRandomData(randomNumber)
        }

        binding.btnShow.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // val bundle = bundleOf("random_number" to randomNumber)
                if (savedInstanceState == null) {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        // add<FirstFragment>(R.id.fragmentContainerView, args = bundle)
                        add<FirstFragment>(R.id.fragmentContainerView)
                    }
                }
            } else {
                if (savedInstanceState == null) {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.let {
                            remove(it)
                        }
                    }
                }
            }
        }

    }
}