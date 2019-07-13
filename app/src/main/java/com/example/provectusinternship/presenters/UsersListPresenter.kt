package com.example.provectusinternship.presenters

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.provectusinternship.RandomUserAPI
import com.example.provectusinternship.adapters.UsersListAdapter
import com.example.provectusinternship.views.MainActivityCallback
import com.example.provectusinternship.model.RandomUserResponse
import com.example.provectusinternship.model.User
import com.example.provectusinternship.views.UsersListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

@InjectViewState
class UsersListPresenter(var mainActivityCallback: MainActivityCallback) : MvpPresenter<UsersListView>() {

    private var userListAdapter: UsersListAdapter? = null

    private var data:MutableList<User>? = null

    private var randomUserAPI:RandomUserAPI =  RandomUserAPI.Factory.create()

    @SuppressLint("CheckResult")
    fun loadUsers() {
        if (data == null) {
            viewState.showProgress()
                randomUserAPI.getRandomUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RandomUserResponse>() {
                    override fun onSuccess(result: RandomUserResponse) {
                        try {
                            data = result.results as MutableList<User>
                            userListAdapter = UsersListAdapter(data!!, mainActivityCallback)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            viewState.showErrorDialog(false)
                        }

                        viewState.hideProgress()
                        viewState.showUsers(userListAdapter!!)
                    }

                    override fun onError(e: Throwable) {
                        viewState.hideProgress()
                        viewState.showErrorDialog(false)
                        e.printStackTrace()
                    }
                })
        } else {
            viewState.showUsers(userListAdapter!!)
        }

    }

    @SuppressLint("CheckResult")
    fun loadUser(){
        viewState.showProgress()
        randomUserAPI.getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<RandomUserResponse>() {
                override fun onSuccess(t: RandomUserResponse) {
                    try {
                        userListAdapter!!.addItem(t.results!![0])
                    } catch (e: Exception){
                        e.printStackTrace()
                        viewState.showErrorDialog(true)
                    }
                    viewState.scrollToPosition(userListAdapter!!.itemCount-1)
                    viewState.hideProgress()
                }

                override fun onError(e: Throwable) {
                    viewState.hideProgress()
                    viewState.showErrorDialog(true)
                    e.printStackTrace()
                }
            })
    }
}