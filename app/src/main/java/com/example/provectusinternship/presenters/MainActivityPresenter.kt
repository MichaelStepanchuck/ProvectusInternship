package com.example.provectusinternship.presenters

import android.annotation.SuppressLint
import android.app.Activity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.provectusinternship.RandomUserAPI
import com.example.provectusinternship.activities.MainActivity
import com.example.provectusinternship.adapters.UsersListAdapter
import com.example.provectusinternship.model.RandomUserResponse
import com.example.provectusinternship.model.User
import com.example.provectusinternship.views.MainActivityView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


@InjectViewState
class MainActivityPresenter(var activity: Activity) : MvpPresenter<MainActivityView>(){

    private var userListAdapter:UsersListAdapter? = null

    @SuppressLint("CheckResult")
    fun loadUsers(){
        viewState.showProgress()
        RandomUserAPI.Factory.create().getRandomUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<RandomUserResponse>() {
                override fun onSuccess(result: RandomUserResponse) {
                    try {
                        userListAdapter = UsersListAdapter((result.results as MutableList<User>?)!!,activity as MainActivity)
                    }catch (e:Exception){
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
    }

    @SuppressLint("CheckResult")
    fun loadUser(){
        viewState.showProgress()
        RandomUserAPI.Factory.create().getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<RandomUserResponse>() {
                override fun onSuccess(t: RandomUserResponse) {
                    try {
                        userListAdapter!!.addItem(t.results!![0])
                    } catch (e:Exception){
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