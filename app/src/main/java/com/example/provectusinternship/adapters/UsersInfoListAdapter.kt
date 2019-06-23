package com.example.provectusinternship.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.provectusinternship.R
import com.example.provectusinternship.viewholders.UserInfoViewHolder

class UsersInfoListAdapter(private val mResults: Array<String?>) : RecyclerView.Adapter<UserInfoViewHolder>() {

    private val drawables = arrayOf(R.drawable.ic_outline_wc_24px,
                                    R.drawable.ic_outline_phone_24px,
                                    R.drawable.ic_outline_person_outline_24px,
                                    R.drawable.ic_outline_lock_24px,
                                    R.drawable.ic_outline_location_city_24px,
                                    R.drawable.ic_outline_map_24px,
                                    R.drawable.ic_outline_email_24px)

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        holder.bind(mResults[position]!!,drawables[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        return UserInfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_info_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mResults.size
    }

}
