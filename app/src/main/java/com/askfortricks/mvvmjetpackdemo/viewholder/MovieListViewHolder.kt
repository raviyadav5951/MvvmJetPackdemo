package com.askfortricks.mvvmjetpackdemo.viewholder

import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.askfortricks.mvvmjetpackdemo.BR
import com.askfortricks.mvvmjetpackdemo.R
import com.askfortricks.mvvmjetpackdemo.constants.Constants
import com.askfortricks.mvvmjetpackdemo.data_models.Movie
import com.askfortricks.mvvmjetpackdemo.data_models.MovieList
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*

//dataBinding will automatically assign the data to each view using the variable we've defined
//in item_movies.xml

class MovieListViewHolder(private val dataBinding: ViewDataBinding):
    RecyclerView.ViewHolder(dataBinding.root) {

    //We will  directly assign the data using the model class object instead of traditional approach-
    //Instead of traditional approach of assigning data to views from here we have directly managed it in
    //item_movies.xml (see the variables inside every view inside curly braces)



    val movie_poster=itemView.img_movie_poster
    fun setUpMovieList(movieListData: Movie) {

        //attached the object with binding variable.
        dataBinding.setVariable(BR.itemMovie, movieListData)
        dataBinding.executePendingBindings()

        movie_poster.load(Constants.BASE_URL_IMAGE_ORIGINAL+movieListData.poster_path)
        itemView.setOnClickListener {
            //using kotlin-ktx
            val bundle= bundleOf("imageUrl" to movieListData.poster_path)
            itemView.findNavController().navigate(R.id.action_movieListFragment_to_movieDetailFragment, bundle)

        }

    }


}