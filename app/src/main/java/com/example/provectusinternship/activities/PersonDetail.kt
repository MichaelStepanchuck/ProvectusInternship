package com.example.provectusinternship.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.provectusinternship.GridDecoration
import com.example.provectusinternship.R
import com.example.provectusinternship.adapters.UsersInfoListAdapter
import com.example.provectusinternship.model.User
import com.example.provectusinternship.presenters.PersonDetailPresenter
import com.example.provectusinternship.views.PersonDetailView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_person_detail.*

class PersonDetail : MvpAppCompatActivity(),PersonDetailView {

    @InjectPresenter
    lateinit var personDetailPresenter: PersonDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportPostponeEnterTransition()
        title = ""

        val currentUser = intent.getSerializableExtra("user") as User
        val imageTransitionName = intent.extras!!.getString(getString(R.string.transition_name))
        userImage.transitionName = imageTransitionName

        loadData(currentUser)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showError(message:String) {
        Snackbar.make(findViewById(android.R.id.content),message,Snackbar.LENGTH_SHORT)
    }

    @SuppressLint("SetTextI18n")
    override fun loadData(currentUser: User) {
        Picasso.get().load(currentUser.picture!!.large).into(userImage, object : Callback {
            override fun onSuccess() {
                supportStartPostponedEnterTransition()
            }

            override fun onError(e: Exception) {
                supportStartPostponedEnterTransition()
                showError(getString(R.string.failed_to_load))
            }
        })
        usersName.text=currentUser.name.toString()
        usersAge.text = "${personDetailPresenter.formatDate(currentUser.dob!!.date!!)} (${currentUser.dob!!.age} years)"
        usersEmail.text = currentUser.email!!.trim()
        userInfoRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        userInfoRecyclerView.addItemDecoration(
            GridDecoration(
                resources.getDimensionPixelSize(R.dimen.my_value),
               2
        ))
        userInfoRecyclerView.adapter = UsersInfoListAdapter(currentUser.toArray())
    }
}
