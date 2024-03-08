package com.example.inclass_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.inclass_api.api.OMDb_API
import com.example.inclass_api.api.OMDb_item
import com.example.inclass_api.api.movieItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val search = findViewById<TextView>(R.id.search_button)
//        val image = findViewById<ImageView>(R.id.image)
        val input = findViewById<EditText>(R.id.input)
        search.setOnClickListener{
            getComments(input.text.toString())

        }

    }

    private fun getComments(input:String){
        val base_url= "http://www.omdbapi.com/"
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val api = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(OMDb_API::class.java)
            Log.d("aaa",api.toString())
        api.getMovie("finding nemo","aa982ac0").enqueue(object : Callback<movieItem> {
            override fun onResponse(
                call: Call<movieItem>,
                response: Response<movieItem>
            ) {

                if (response.isSuccessful){
                    Log.d("???",response.toString())
                    val news = response.body()!!
                    Log.d("????",news.toString())
//                    textview.text = news.articles[0].title
//                    callback(news)

                }
            }

            override fun onFailure(call: Call<movieItem>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}