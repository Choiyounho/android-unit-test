package com.soten.unittest.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soten.unittest.R
import com.soten.unittest.calculate.Calculator
import com.soten.unittest.calculate.CalculatorViewModel
import com.soten.unittest.calculate.CalculatorViewModelFactory
import com.soten.unittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculatorViewModel
    private lateinit var factory: CalculatorViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = CalculatorViewModelFactory(Calculator())
        viewModel = ViewModelProvider(this, factory).get(CalculatorViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}