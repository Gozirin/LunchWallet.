package com.example.lunchwallet.admin.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.admin.user.model.Users

class UserScreenAdapter(private val users: ArrayList<Users>) : RecyclerView.Adapter<UserScreenAdapter.UserScreenViewHolder>() {

    inner class UserScreenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.user_screen_fragment_nonso_Tv)
        val userStack: TextView = itemView.findViewById(R.id.user_screen_fragment_python_Tv)
        val userLocation: TextView = itemView.findViewById(R.id.user_screen_fragment_farapark_Tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserScreenViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.fragment_admin_user_screen_recycler_view, parent, false)
        return UserScreenViewHolder(view)
    }

//    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: UserScreenViewHolder, position: Int) {
        val current = users[position]
        holder.apply {
            //           Picasso.get().load(current.name).into(userName)
            userName.text = current.userName
            userStack.text = current.userStack
            userLocation.text = current.userLocation
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
