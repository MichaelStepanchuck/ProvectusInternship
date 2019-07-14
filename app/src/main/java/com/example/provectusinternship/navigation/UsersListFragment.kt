package com.example.provectusinternship.navigation

import androidx.fragment.app.Fragment
import com.example.provectusinternship.fragments.UsersList
import ru.terrakok.cicerone.android.support.SupportAppScreen


class UsersListFragment : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return UsersList()
    }

}