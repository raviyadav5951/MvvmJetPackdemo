package com.askfortricks.mvvmjetpackdemo.foundations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    //We will use this 'empty' to check if data is empty
    val empty = MutableLiveData<Boolean>().apply { value = false }

    //We will use this 'dataLoading' to tell if api is being called and waiting for the response
    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

    //We will use 'toastMessage' to display toast
    val toastMessage = MutableLiveData<String>()
}