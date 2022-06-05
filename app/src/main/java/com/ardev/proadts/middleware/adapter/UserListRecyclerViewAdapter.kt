package com.ardev.proadts.middleware.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ardev.proadts.R
import com.ardev.proadts.component.card.CardListUsers
import com.ardev.proadts.models.response.user.UserResponse

class UserListRecyclerViewAdapter(
    private  val context: Context?,
    private val values: List<UserResponse>,
    private val callBack: CallBack
) : RecyclerView.Adapter<UserListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.card_user_view_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  item = values[position]
        holder.cardUserList.render(item.login.toString())
        holder.cardUserList.setOnClickListener {
            callBack.onItemSelected(item)
        }
    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardUserList : CardListUsers = itemView.findViewById(R.id.card_user_view_list)
    }

    interface CallBack {
        fun onItemSelected( user: UserResponse)
    }



}