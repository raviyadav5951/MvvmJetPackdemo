package com.askfortricks.mvvmjetpackdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askfortricks.mvvmjetpackdemo.api.ApiControllers
import com.askfortricks.mvvmjetpackdemo.data_models.Result
import com.askfortricks.mvvmjetpackdemo.foundations.BaseViewModel

class MovieListViewModel :BaseViewModel(){

    // todo :populate list and pass to adapter for displaying in recycler view.

    val movieListLive = MutableLiveData<List<Result>>()

    fun fetchMovieList() {
        dataLoading.value = true
        ApiControllers.getInstance()?.callGetTopRatedMoviesApi { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                movieListLive.value = response?.results
                empty.value = false
            } else {
                empty.value = true
            }
        }

    }
}
