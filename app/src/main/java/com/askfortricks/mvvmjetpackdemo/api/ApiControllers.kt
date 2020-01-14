package com.askfortricks.mvvmjetpackdemo.api

import com.askfortricks.mvvmjetpackdemo.data_models.MovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * This class will contain all the api calls which we will call using getInstance.
 */
class ApiControllers{


    //Equivalent of getInstance method that we call in Java before calling any method of the class
    companion object{
        private var INSTANCE:ApiControllers?=null

        fun getInstance():ApiControllers?{

            ApiControllers().apply {
                INSTANCE=this
            }
            return INSTANCE

        }
    }

    //After getting the instance we will call the api methods
    //We have returned the whole function result type which will return two things
    //to the caller function.

    fun callGetTopRatedMoviesApi(onResult:(isSuccess: Boolean,response:MovieList?)->Unit){

        RestApiClient.instance.getMovieListFromServer().enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                onResult(false, null)
            }

        })

    }

}