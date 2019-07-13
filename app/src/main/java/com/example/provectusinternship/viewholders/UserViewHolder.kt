package com.example.provectusinternship.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.provectusinternship.R
import com.example.provectusinternship.model.User
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso


class UserViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val userName: TextView = itemView.findViewById(R.id.userNameTextView)
    private val userEmail: TextView = itemView.findViewById(R.id.userEmailTextView)
    internal val userImage: CircularImageView = itemView.findViewById(R.id.userImage)
    internal val insideContainer:ConstraintLayout = itemView.findViewById(R.id.insideContainer)
    internal val reorderImageButton: ImageView = itemView.findViewById(R.id.reorderImageView)


    @SuppressLint("ClickableViewAccessibility")
    internal fun bind(user: User) {
        userName.text = user.name.toString()
        userEmail.text = user.email
        Picasso.get().load(user.picture!!.medium).into(userImage)
    }

}