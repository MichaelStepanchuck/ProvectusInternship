package com.example.provectusinternship.navigation

import android.content.Context
import com.example.provectusinternship.activities.MainActivity
import android.content.Intent
import ru.terrakok.cicerone.android.support.SupportAppScreen


class MainScreen : SupportAppScreen() {

    override fun getActivityIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }

}