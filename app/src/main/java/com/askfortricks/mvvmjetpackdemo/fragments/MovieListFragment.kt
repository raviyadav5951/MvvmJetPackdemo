package com.askfortricks.mvvmjetpackdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.askfortricks.mvvmjetpackdemo.adapter.MovieListAdapter
import com.askfortricks.mvvmjetpackdemo.api.ApiControllers
import com.askfortricks.mvvmjetpackdemo.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {

    private lateinit var movieListDataBinding:FragmentMovieListBinding
    private lateinit var movieListAdapter:MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}