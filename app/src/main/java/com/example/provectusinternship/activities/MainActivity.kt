package com.example.provectusinternship.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.provectusinternship.ProvectusInternship
import com.example.provectusinternship.R
import com.example.provectusinternship.model.User
import com.example.provectusinternship.navigation.MainScreen
import com.example.provectusinternship.navigation.UserProfileFragment
import com.example.provectusinternship.navigation.UsersListFragment
import com.example.provectusinternship.views.MainActivityCallback
import com.mikhaellopez.circularimageview.CircularImageView
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command


class MainActivity : MvpAppCompatActivity(), MainActivityCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.all_users)
    }

    override fun onUsersListItemCLickListener(user: User, sharedImageView: CircularImageView) {
        ProvectusInternship.INSTANCE.router.navigateTo(UserProfileFragment(user))
        //Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.action_usersList_to_personDetail,bundle)
        showHomeButton()
        setTitle("")
    }

    override fun showHomeButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun hideHomeButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    override fun setTitle(message: String) {
        title = message
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
       super.onBackPressed()
        hideHomeButton()
        setTitle(getString(R.string.all_users))
    }

    override fun onResume() {
        super.onResume()
        val navigator = object : SupportAppNavigator(this, R.id.fragment_container) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                super.setupFragmentTransaction(
                    command,
                    currentFragment,
                    nextFragment,
                    fragmentTransaction
                )
                fragmentTransaction!!.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
        ProvectusInternship.INSTANCE.navigatorHolder.setNavigator(navigator)
        ProvectusInternship.INSTANCE.router.navigateTo(UsersListFragment())
    }
}

