package com.example.provectusinternship.views

import com.arellomobile.mvp.MvpView
import com.example.provectusinternship.model.User
import com.mikhaellopez.circularimageview.CircularImageView

interface MainActivityCallback : MvpView {
    fun onUsersListItemCLickListener(user: User, sharedImageView: CircularImageView)
    fun showHomeButton()
    fun hideHomeButton()
    fun setTitle(message:String)
}