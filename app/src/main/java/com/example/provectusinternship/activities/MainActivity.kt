package com.example.provectusinternship.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.provectusinternship.R
import com.example.provectusinternship.SwipeAndDragHelper
import com.example.provectusinternship.adapters.UsersListAdapter
import com.example.provectusinternship.dialogs.BadConnectionDialog
import com.example.provectusinternship.model.User
import com.example.provectusinternship.presenters.MainActivityPresenter
import com.example.provectusinternship.views.MainActivityView
import com.mikhaellopez.circularimageview.CircularImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpAppCompatActivity(), MainActivityView {

    private var dialog: ProgressDialog? = null

    @InjectPresenter
    lateinit var mainActivityPresenter: MainActivityPresenter

    @ProvidePresenter
    fun provideMainActivityPresenter(): MainActivityPresenter {
        return MainActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.all_users)

        loadDialogInit()

        usersRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        usersRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && addUserFAB.isShown) {
                    addUserFAB.hide()
                } else if (dy < 0 &&  !addUserFAB.isShown)
                    addUserFAB.show()
            }
        })

        addUserFAB.setOnClickListener {mainActivityPresenter.loadUser()}
        mainActivityPresenter.loadUsers()

    }

    override fun onUsersListItemCLickListener(user: User,sharedImageView: CircularImageView) {
        val intent = Intent(this@MainActivity,PersonDetail::class.java)
        intent.putExtra("user",user)
        intent.putExtra(getString(R.string.transition_name), ViewCompat.getTransitionName(sharedImageView))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, sharedImageView, ViewCompat.getTransitionName(sharedImageView)!!)
        startActivity(intent, options.toBundle())
    }

    override fun showUsers(usersListAdapter: UsersListAdapter) {
        usersRecyclerView.adapter = usersListAdapter
        val swipeAndDragHelper = SwipeAndDragHelper(usersListAdapter)
        val touchHelper = ItemTouchHelper(swipeAndDragHelper)
        usersListAdapter.setTouchHelper(touchHelper)
        touchHelper.attachToRecyclerView(usersRecyclerView)
    }

    override fun showErrorDialog(isUserAdd:Boolean) {
        BadConnectionDialog(this@MainActivity,isUserAdd).show()
    }

    override fun showProgress() {
        dialog!!.show()
    }

    override fun hideProgress() {
        dialog!!.hide()
    }

    override fun scrollToPosition(position: Int) {
        usersRecyclerView.layoutManager!!.scrollToPosition(position)
    }

    override fun loadDialogInit() {
        dialog = ProgressDialog(this)
        dialog!!.setTitle(getString(R.string.loading))
        dialog!!.setMessage(getString(R.string.please_wait))
        dialog!!.setCancelable(false)
    }

}

