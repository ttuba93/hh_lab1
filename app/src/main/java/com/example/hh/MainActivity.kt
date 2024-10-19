package com.example.hh

import JobAdapter
import JobDetailsActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var jobAdapter: JobAdapter
    private val jobList = listOf(
        Job("Software Engineer", "ABC Corp", "$80,000", "New York"),
        Job("Data Scientist", "XYZ Inc.", "$90,000", "San Francisco"),
        Job("Android Developer", "Mobile Solutions", "$75,000", "Los Angeles")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        jobAdapter = JobAdapter(jobList) { job ->
            val intent = Intent(this, JobDetailsActivity::class.java)
            intent.putExtra("job", job)
            startActivity(intent)
        }
        binding.recyclerView.adapter = jobAdapter

        // Setup search functionality
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                val filteredJobs = jobList.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.company.contains(query, ignoreCase = true)
                }
                jobAdapter.updateJobs(filteredJobs)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}


