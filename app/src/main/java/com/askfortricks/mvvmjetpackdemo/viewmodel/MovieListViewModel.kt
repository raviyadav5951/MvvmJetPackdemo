package com.askfortricks.mvvmjetpackdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.askfortricks.mvvmjetpackdemo.api.ApiRepository
import com.askfortricks.mvvmjetpackdemo.model.Movie
import com.askfortricks.mvvmjetpackdemo.foundations.BaseViewModel

class MovieListViewModel :BaseViewModel(){

    //we will be setting observer on this list
    var movieListLive = MutableLiveData<List<Movie>>()

    fun fetchMovieList() {
        dataLoading.value = true
        ApiRepository.getInstance()?.callGetTopRatedMoviesApi { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {

                if(response==null || response.results.isEmpty())
                {
                    movieListLive.value = response?.results
                    empty.value = true
                }
                else{
                    movieListLive.value = response?.results
                    empty.value = false
                }

            }
            else {
                Log.e("api","is success =false")
                empty.value = true
            }
        }

    }
}
