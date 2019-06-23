package com.example.provectusinternship.views

import com.arellomobile.mvp.MvpView
import com.example.provectusinternship.adapters.UsersListAdapter
import com.example.provectusinternship.model.User
import com.mikhaellopez.circularimageview.CircularImageView

interface MainActivityView : MvpView {
   fun onUsersListItemCLickListener(user:User,sharedImageView: CircularImageView)
   fun showUsers(usersListAdapter: UsersListAdapter)
   fun showErrorDialog(isUserAdd: Boolean)
   fun showProgress()
   fun hideProgress()
   fun scrollToPosition(position: Int)
   fun loadDialogInit()
}