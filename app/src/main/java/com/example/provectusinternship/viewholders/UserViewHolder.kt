package com.example.provectusinternship.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.provectusinternship.R
import com.example.provectusinternship.model.User
import com.google.android.material.card.MaterialCardView
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso


class UserViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val userName: TextView = itemView.findViewById(R.id.userNameTextView)
    private val userEmail: TextView = itemView.findViewById(R.id.userEmailTextView)
    internal val userImage: CircularImageView = itemView.findViewById(R.id.userImage)
    private val outsideContainer: MaterialCardView = itemView.findViewById(R.id.outsideContainer)
    internal val insideContainer:ConstraintLayout = itemView.findViewById(R.id.insideContainer)
    internal val reorderImageButton: ImageView = itemView.findViewById(R.id.reorderImageView)

    @SuppressLint("ClickableViewAccessibility")
    internal fun bind(user: User) {
        outsideContainer.animation = AnimationUtils.loadAnimation(outsideContainer.context,R.anim.item_animation_fall_down)
        userName.text = user.name.toString()
        userEmail.text = user.email
        Picasso.get().load(user.picture!!.medium).into(userImage)
    }

}