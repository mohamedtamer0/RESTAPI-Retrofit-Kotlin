package com.example.restapi_retrofit_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var PostTitleTV: TextView
    lateinit var PostBodyTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val post = Post(5, "CODEDEV", "Hello World")

        PostTitleTV = findViewById(R.id.post_title_tv)
        PostBodyTV = findViewById(R.id.post_body_tv)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
                .build()


        val apiInterface = retrofit.create(ApiInterface::class.java)


        val call = apiInterface.getPost(1)

        call!!.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                val resBody = response.body()
                PostTitleTV.setText(resBody?.title)
                PostBodyTV.setText(resBody?.body)
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                PostTitleTV.setText(t.message.toString())
            }

        })


    }
}