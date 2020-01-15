package com.askfortricks.mvvmjetpackdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.askfortricks.mvvmjetpackdemo.data_models.Movie
import com.askfortricks.mvvmjetpackdemo.databinding.ItemMoviesBinding
import com.askfortricks.mvvmjetpackdemo.viewholder.MovieListViewHolder
import com.askfortricks.mvvmjetpackdemo.viewmodels.MovieListViewModel

//Compare this class with this github project
//https://github.com/raviyadav5951/VolleyWithGsonDemo/blob/master/app/src/main/java/com/askfortrciks/volleywithgsondemo/adapter/MoviesRecyclerAdapter.java

class MovieListAdapter(private val movieListViewModel: MovieListViewModel) :
    RecyclerView.Adapter<MovieListViewHolder>() {

    var movieList: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val dataBinding=ItemMoviesBinding.inflate(inflater,parent,false)
        return MovieListViewHolder(dataBinding)
    }

    //this is equivalen to return the movieList.size
    override fun getItemCount(): Int=movieList.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        //setUpMovieList will pass the object to MovieListViewHolder
        holder.setUpMovieList(movieList[position])
    }


}