package com.askfortricks.mvvmjetpackdemo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.askfortricks.mvvmjetpackdemo.model.Movie
import com.askfortricks.mvvmjetpackdemo.databinding.ItemMoviesBinding
import com.askfortricks.mvvmjetpackdemo.viewmodel.MovieListViewModel
import com.askfortricks.mvvmjetpackdemo.view.MovieListViewHolder

//Compare this class with this github project
//https://github.com/raviyadav5951/VolleyWithGsonDemo/blob/master/app/src/main/java/com/askfortrciks/volleywithgsondemo/adapter/MoviesRecyclerAdapter.java

class MovieListAdapter(private val movieListViewModel: MovieListViewModel) :
    RecyclerView.Adapter<MovieListViewHolder>() {

    var movieList: List<Movie>? = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val dataBinding=ItemMoviesBinding.inflate(inflater,parent,false)
        return MovieListViewHolder(dataBinding,movieListViewModel)
    }

    //this is equivalen to return the movieList.size
    override fun getItemCount(): Int{
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        //setUpMovieList will pass the object to MovieListViewHolder
        holder.setUpMovieList(movieList?.get(position))
    }

    //this method will be called when api returns the list.
    fun updateRepoList(repoList: List<Movie>?) {
        this.movieList = repoList
        notifyDataSetChanged()
    }

}