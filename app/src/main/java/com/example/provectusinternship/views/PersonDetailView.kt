package com.example.provectusinternship.views

import com.arellomobile.mvp.MvpView
import com.example.provectusinternship.model.User

interface PersonDetailView : MvpView {
    fun loadData(currentUser: User)
    fun showError(message:String)
}