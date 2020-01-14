package com.askfortricks.mvvmjetpackdemo.api

import com.askfortricks.mvvmjetpackdemo.constants.Constants
import com.askfortricks.mvvmjetpackdemo.data_models.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * If you have worked with Retrofit then you know we have to call the API using methods
 * added in interface.
 * For help you can check this github repo:
 * https://github.com/raviyadav5951/RetrofitDemo
 **/
interface RestApiService {

    //Url format will be something like:
//    https://api.themoviedb.org/3/movie/top_rated?api_key=23fc7389372548c592b1f08cb8a0dffe
//    https://api.themoviedb.org/3/movie/top_rated?api_key=replace with your api key.


    @GET("movie/top_rated")
    fun getMovieListFromServer(@Query("api_key") api_key: String = Constants.API_KEY): Call<MovieList>
}