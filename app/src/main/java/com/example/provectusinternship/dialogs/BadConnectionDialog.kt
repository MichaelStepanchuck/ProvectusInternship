package com.example.provectusinternship.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.provectusinternship.R
import com.example.provectusinternship.fragments.UsersList
import kotlinx.android.synthetic.main.internet_troubles_dialog_layout.*

class BadConnectionDialog(var fragment: Fragment, var isUserAdd:Boolean) : Dialog(fragment.context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.internet_troubles_dialog_layout)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        this.window!!.attributes = lp
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.setCancelable(false)

        retry.setOnClickListener {
            this.dismiss()
            if (isUserAdd) (fragment as UsersList).usersListPresenter.loadUser()
                else (fragment as UsersList).usersListPresenter.loadUsers()
        }

    }

}