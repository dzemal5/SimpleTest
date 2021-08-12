package org.com.testing.with.simpletest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.com.testing.with.simpletest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private lateinit var mainActivityViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainActivityViewModel.fetchData()
        mainActivityViewModel.data.observe(this, Observer {
            getMyList(it)
        })

    }

    fun getMyList(article: List<Article>) {
        val articleListAdapter = RVCustomAdapter(article)
        binding?.mRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleListAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}