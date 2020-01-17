package com.askfortricks.mvvmjetpackdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import com.askfortricks.mvvmjetpackdemo.R
import com.askfortricks.mvvmjetpackdemo.constants.Constants
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.containsKey("bundlePosterUrl") == true) {
            val imageUrl = arguments?.getString("bundlePosterUrl")
            imageUrl.let {
                img_movie_poster.load(Constants.BASE_URL_IMAGE_ORIGINAL + imageUrl) {
                    crossfade(true)
                    placeholder(R.drawable.placeholder)
                }
            }

        }

    }

}