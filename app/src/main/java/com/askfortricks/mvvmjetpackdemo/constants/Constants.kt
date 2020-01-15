package com.askfortricks.mvvmjetpackdemo.constants

class Constants {
    //Movie list response :
//    http://jsoneditoronline.org/?id=ae1fce6a5e4c4f06a9f8e80ad9b0ab92
    companion object {
        //Main Host Url to access apis
        const val BASE_URL = "https://api.themoviedb.org/3/"

        //Image urls
        const val BASE_URL_IMAGE_ORIGINAL = "https://image.tmdb.org/t/p/original"
        const val BASE_URL_IMAGE_W_500 = "https://image.tmdb.org/t/p/w500"

        //api key (Its my personal) you have to crate your own to avoid suspension of your account

        //api key (Its my personal) you have to crate your own to avoid suspension of your account
        const val API_KEY = "23fc7389372548c592b1f08cb8a0dffe"


        //api connections
        const val MOVIE = "movie/"
        const val TOP_RATED = "top_rated"

        const val REQUEST_TIMEOUT_DURATION = 10
        const val DEBUG = true
    }
}