package com.example.provectusinternship.navigation

import androidx.fragment.app.Fragment
import com.example.provectusinternship.fragments.PersonDetail
import com.example.provectusinternship.model.User
import ru.terrakok.cicerone.android.support.SupportAppScreen

class UserProfileFragment(var user: User) : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return PersonDetail.newInstance(user)
    }

}