package com.mvvm.simplemvvm.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.mvvm.simplemvvm.BR
import com.mvvm.simplemvvm.model.User

/**
 * The methods were called in the layout are implemented in this class.
 * This class can also extend ViewModel. But we need BaseObservable since it converts the data into streams
 * and notifies when the  property is changed.
 *
 * Note:BR class is auto-generated from data binding when you rebuild the project
 */
class LoginViewModel(private val user: User = User("", "")) : BaseObservable() {

    @Bindable
    var toastMsg: String? = null

    /**
     * Function is used to get text from email edit text in xml.
     */
    fun afterEmailTextChanged(s: CharSequence) {
        user.email = s.toString()
    }

    /**
     * Function is used to get text from password edit text in xml.
     */
    fun afterPassTextChanged(s: CharSequence) {
        user.password = s.toString()
    }

    /**
     * Login button click function.
     */
    fun onLoginClicked() {
        toastMsg = if (user.isValidUser()) {
            mSuccessMsg
        } else {
            mErrorMsg
        }
        /**
         * Notify toast message.
         */
        notifyPropertyChanged(BR.toastMsg)
    }

    companion object {
        private const val mSuccessMsg: String = "Login  successful"
        private const val mErrorMsg: String = "Email or Password not valid"
    }
}