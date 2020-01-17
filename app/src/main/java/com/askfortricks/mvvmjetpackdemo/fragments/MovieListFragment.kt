package com.askfortricks.mvvmjetpackdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.askfortricks.mvvmjetpackdemo.adapter.MovieListAdapter
import com.askfortricks.mvvmjetpackdemo.databinding.FragmentMovieListBinding
import com.askfortricks.mvvmjetpackdemo.viewmodels.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment() {

    private lateinit var movieListDataBinding:FragmentMovieListBinding
    private lateinit var movieListAdapter:MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieListDataBinding= FragmentMovieListBinding.inflate(inflater,container,false)
            .apply {
                viewmodel= ViewModelProviders.of(this@MovieListFragment).get(MovieListViewModel::class.java)
                lifecycleOwner = viewLifecycleOwner
        }
        return movieListDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //our view model is responsible for providing the data to fragment.
        movieListDataBinding.viewmodel?.fetchMovieList()

        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter() {
        val viewModel=movieListDataBinding.viewmodel
        if(viewModel!=null){
            movieListAdapter = MovieListAdapter(viewModel) //it is viewModel (which is not null)
            val layoutManager = LinearLayoutManager(activity)
            movie_list.layoutManager = layoutManager
            movie_list.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            movie_list.adapter = movieListAdapter
        }
    }

    /**
     * we are setting observer on movieListLive as it will be updated on api call.
     */

    private fun setupObservers() {

        try {
            movieListDataBinding.viewmodel?.movieListLive?.observe(viewLifecycleOwner, Observer {
                movieListAdapter.updateRepoList(it)
            })

            movieListDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
                Toast.makeText(activity,it,Toast.LENGTH_LONG).show()
            })
        } catch (e: Exception) {
            Log.e("exception in observer:",e.localizedMessage)
        }
    }

}