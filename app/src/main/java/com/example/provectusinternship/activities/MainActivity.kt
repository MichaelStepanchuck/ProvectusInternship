package com.example.provectusinternship.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.Navigation
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.provectusinternship.R
import com.example.provectusinternship.model.User
import com.example.provectusinternship.views.MainActivityCallback
import com.mikhaellopez.circularimageview.CircularImageView


class MainActivity : MvpAppCompatActivity(), MainActivityCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.all_users)
    }

    override fun onUsersListItemCLickListener(user: User, sharedImageView: CircularImageView) {
        val bundle = Bundle()
        bundle.putSerializable("user",user)
        Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.action_usersList_to_personDetail,bundle)
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
}

