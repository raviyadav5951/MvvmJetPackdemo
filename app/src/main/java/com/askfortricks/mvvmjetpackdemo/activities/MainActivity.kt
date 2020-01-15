package com.askfortricks.mvvmjetpackdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.askfortricks.mvvmjetpackdemo.R
import com.askfortricks.mvvmjetpackdemo.api.ApiControllers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this,
        findNavController(R.id.main_nav_fragment))

        ApiControllers.getInstance()?.callGetTopRatedMoviesApi { isSuccess, response ->

            if (isSuccess) {
                response?.movies
                Log.e("answer", "results size==" + response?.movies?.size)

            } else {

                Log.e("answer", "failed")
            }


        }

    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()

}
