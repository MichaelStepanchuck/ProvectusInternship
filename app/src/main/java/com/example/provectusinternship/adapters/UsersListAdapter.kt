package com.example.provectusinternship.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.provectusinternship.R
import com.example.provectusinternship.SwipeAndDragHelper
import com.example.provectusinternship.views.MainActivityCallback
import com.example.provectusinternship.model.User
import com.example.provectusinternship.viewholders.UserViewHolder


class UsersListAdapter(private val mResults: MutableList<User>, private var MainActivityCallback: MainActivityCallback) :
    RecyclerView.Adapter<UserViewHolder>(), SwipeAndDragHelper.ActionCompletionContract {

    private var touchHelper: ItemTouchHelper? = null

    override fun onViewMoved(oldPosition: Int, newPosition: Int) {
        val targetUser = mResults[oldPosition]
        mResults.removeAt(oldPosition)
        mResults.add(newPosition, targetUser)
        notifyItemMoved(oldPosition, newPosition)
    }

    override fun onViewSwiped(position: Int) {
        mResults.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mResults.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false))
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(mResults[position])
        holder.insideContainer.setOnClickListener {
            MainActivityCallback.onUsersListItemCLickListener(mResults[position],holder.userImage)
            Log.d("",mResults[position].name.toString())
        }
        holder.reorderImageButton.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                touchHelper!!.startDrag(holder)
            }
            false
        }
    }

    override fun getItemCount(): Int {
        return mResults.size
    }

    fun setTouchHelper(touchHelper: ItemTouchHelper) {
        this.touchHelper = touchHelper
    }

    fun addItem(user:User){
        mResults.add(user)
        notifyItemInserted(mResults.size-1)
    }

}
