package com.example.provectusinternship.presenters

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.provectusinternship.views.PersonDetailView
import java.text.SimpleDateFormat


@InjectViewState
class PersonDetailPresenter: MvpPresenter<PersonDetailView>(){
        @SuppressLint("SimpleDateFormat")
        fun formatDate(data:String):String{
            val inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val date = inFormat.parse(data)
            val format = SimpleDateFormat("dd/MM/yyy")
            return format.format(date)
        }
}