package com.example.provectusinternship.fragments


import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.provectusinternship.R
import com.example.provectusinternship.SwipeAndDragHelper
import com.example.provectusinternship.activities.MainActivity
import com.example.provectusinternship.adapters.UsersListAdapter
import com.example.provectusinternship.dialogs.BadConnectionDialog
import com.example.provectusinternship.presenters.UsersListPresenter
import com.example.provectusinternship.views.UsersListView
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersList : MvpAppCompatFragment(), UsersListView {

    @InjectPresenter
    lateinit var usersListPresenter: UsersListPresenter

    @ProvidePresenter
    fun provideUsersListPresenter():UsersListPresenter{
        return UsersListPresenter(activity as MainActivity)
    }

    private var dialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view:View = inflater.inflate(R.layout.fragment_users_list, container, false)
       loadDialogInit()
       return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            usersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            usersRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0 && addUserFAB.isShown) {
                        addUserFAB.hide()
                    } else if (dy < 0 && !addUserFAB.isShown)
                        addUserFAB.show()
                }
            })

            addUserFAB.setOnClickListener { usersListPresenter.loadUser() }
            usersListPresenter.loadUsers()

    }

    override fun showUsers(usersListAdapter: UsersListAdapter) {
        usersRecyclerView.adapter = usersListAdapter
        val swipeAndDragHelper = SwipeAndDragHelper(usersListAdapter)
        val touchHelper = ItemTouchHelper(swipeAndDragHelper)
        usersListAdapter.setTouchHelper(touchHelper)
        touchHelper.attachToRecyclerView(usersRecyclerView)
    }

    override fun showErrorDialog(isUserAdd:Boolean) {
        BadConnectionDialog(this,isUserAdd).show()
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
        dialog = ProgressDialog(context)
        dialog!!.setTitle(getString(R.string.loading))
        dialog!!.setMessage(getString(R.string.please_wait))
        dialog!!.setCancelable(false)
    }

}

