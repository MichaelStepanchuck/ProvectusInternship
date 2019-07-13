package com.example.provectusinternship.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.provectusinternship.model.User

@StateStrategyType(AddToEndSingleStrategy::class)
interface PersonDetailView : MvpView {
    fun loadData(currentUser: User)
    fun showError(message:String)
}