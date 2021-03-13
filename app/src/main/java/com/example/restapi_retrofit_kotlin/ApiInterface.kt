package com.example.restapi_retrofit_kotlin

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
//    @GET("posts/id")
//    fun getPost(@Path("id") postid: Int): Call<Post?>?

    @GET("posts/{id}")
   fun getPost(@Path("id") postid: Int): Call<Post?>?

    @POST("posts")
    fun storePost(@Body post: Post?): Call<Post?>?
}
