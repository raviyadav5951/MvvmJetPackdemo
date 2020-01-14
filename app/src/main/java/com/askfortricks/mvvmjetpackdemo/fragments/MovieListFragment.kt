package com.askfortricks.mvvmjetpackdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.askfortricks.mvvmjetpackdemo.api.ApiControllers

class MovieListFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*ApiControllers.getInstance().callGetTopRatedMoviesApi { isSuccess, response ->

            if (isSuccess) {
                response?.results
                Log.e("answer","results size=="+response?.results?.size)

            } else {

                Log.e("answer","failed")
            }
        }*/
    }
}