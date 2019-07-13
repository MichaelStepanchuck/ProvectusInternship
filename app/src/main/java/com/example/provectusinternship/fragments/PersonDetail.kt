package com.example.provectusinternship.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
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
import kotlinx.android.synthetic.main.fragment_person_detail.*

class PersonDetail : MvpAppCompatFragment(),PersonDetailView {

    @InjectPresenter
    lateinit var personDetailPresenter: PersonDetailPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = arguments!!.getSerializable("user") as User
        loadData(currentUser)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_detail,container,false)
    }


    override fun showError(message:String) {
        Snackbar.make(view!!.findViewById(android.R.id.content),message,Snackbar.LENGTH_SHORT)
    }

    @SuppressLint("SetTextI18n")
    override fun loadData(currentUser: User) {
        Picasso.get().load(currentUser.picture!!.large).into(userImage, object : Callback {
            override fun onSuccess() {
                startPostponedEnterTransition();
            }

            override fun onError(e: Exception) {
                startPostponedEnterTransition();
                showError(getString(R.string.failed_to_load))
            }
        })
        usersName.text=currentUser.name.toString()
        usersAge.text = "${personDetailPresenter.formatDate(currentUser.dob!!.date!!)} (${currentUser.dob!!.age} years)"
        usersEmail.text = currentUser.email!!.trim()
        userInfoRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        userInfoRecyclerView.addItemDecoration(GridDecoration(resources.getDimensionPixelSize(R.dimen.my_value), 2))
        userInfoRecyclerView.adapter = UsersInfoListAdapter(currentUser.toArray())
    }

}
