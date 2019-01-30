package com.mvvm.simplemvvm.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.mvvm.simplemvvm.R
import com.mvvm.simplemvvm.databinding.ActivityMainBinding
import com.mvvm.simplemvvm.viewmodels.LoginViewModel

/**
 *  The ActivityMainBinding class is auto-generated from the layout.
 *  The @BindingAdapter method gets triggered whenever toastMessage attribute defined on the Button is changed.
 *  It must use the same attribute as defined in the XML and in the ViewModel.
 *
 *  Note: In this application, the Model updates the data and the ViewModel passes the changes in an Observable.
 *  The View listens to the ViewModel through two-way data binding.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = LoginViewModel()
        activityMainBinding.executePendingBindings()
    }

    companion object {
        /**
         * This function gets triggered whenever toastMessage attribute defined on the Button is changed.
         */
        @JvmStatic
        @BindingAdapter("toastMsg")
        fun runMe(view: View, message: String?) {
            if (message != null)
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
