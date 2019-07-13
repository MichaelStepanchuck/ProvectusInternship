package com.example.provectusinternship.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.provectusinternship.adapters.UsersListAdapter

@StateStrategyType(OneExecutionStateStrategy::class)
interface UsersListView : MvpView{
    fun showUsers(usersListAdapter: UsersListAdapter)
    fun showErrorDialog(isUserAdd: Boolean)
    fun showProgress()
    fun hideProgress()
    fun scrollToPosition(position: Int)
    fun loadDialogInit()
}