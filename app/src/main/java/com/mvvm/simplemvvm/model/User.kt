package com.mvvm.simplemvvm.model

import android.text.TextUtils
import android.util.Patterns

/**
 * User :The Model would hold the user’s email and password.
 * The ViewModel would look towards the above Model before passing on the data stream.
 */
data class User(var email: String, var password: String) {

    /**
     * Function used to validate user email and password.
     * @return true if valid user else false.
     */
    fun isValidUser(): Boolean {
        return !TextUtils.isEmpty(email)
                && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 5
    }
}