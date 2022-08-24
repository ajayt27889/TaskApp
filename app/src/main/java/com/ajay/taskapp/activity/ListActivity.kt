package com.ajay.taskapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ajay.taskapp.adapter.MainAdapter
import com.ajay.taskapp.databinding.ActivityListBinding
import com.ajay.taskapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityListBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpObserver()
        setUpView()
        loadData()
    }

    private fun setUpObserver() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.repositoriesData.observe(this){ updatedRestaurants ->
            binding.progressBar.visibility = View.GONE
            mainAdapter.submitList(updatedRestaurants)
        }
    }

    private fun setUpView() {
        mainAdapter = MainAdapter()
        binding.apply {
            recyclerview.apply {
                adapter = mainAdapter
                progressBar.visibility = View.VISIBLE
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }

    private fun loadData() {
        mainViewModel.getRepositories()
    }
}