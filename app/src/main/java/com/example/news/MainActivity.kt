package com.example.news

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var pageNum = 1
    var totalResults=-1
    lateinit var adapter: NewsAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNews()



    }

    private fun getNews() {
        val news = NewsService.newsinstance.getHeadlines("in", pageNum)
        news.enqueue(object : Callback<Newss> {
            override fun onResponse(call: Call<Newss>, response: Response<Newss>) {
                val news = response.body()
                if (news != null) {
                    totalResults = news.totalResults
                    Log.d("pulkit", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    binding.newsList.adapter=adapter
                    binding.newsList.layoutManager=LinearLayoutManager(this@MainActivity)


                }
            }

            override fun onFailure(call: Call<Newss>, t: Throwable) {
                Log.d("pulkit", "error in fetching news", t)

            }
        })

    }
}