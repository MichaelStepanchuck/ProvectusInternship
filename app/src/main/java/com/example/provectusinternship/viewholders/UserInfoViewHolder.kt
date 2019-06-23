package com.example.provectusinternship.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.provectusinternship.R

class UserInfoViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val infoDrawable: ImageView = itemView.findViewById(R.id.infoDrawableImageView)
    private val infoText: TextView = itemView.findViewById(R.id.infoTextView)

    @SuppressLint("ClickableViewAccessibility")
    internal fun bind(data: String,drawableId: Int) {
        infoDrawable.setImageDrawable(infoDrawable.context.getDrawable(drawableId))
        infoText.text = data
    }

}