package com.example.news

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=api_key
//  https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=api_key

const val Base_url = "https://newsapi.org/"
const val api_key ="339809e32d1948898c148961dd4aa166"

interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$api_key")
    fun getHeadlines(@Query("country")country: String,@Query("page") page: Int): Call<Newss>
}

object NewsService{
    val newsinstance: NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance=retrofit.create(NewsInterface::class.java)

    }
}