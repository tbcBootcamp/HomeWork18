package com.example.hw18.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw18.databinding.UserItemBinding
import com.example.hw18.models.UserModel

class UsersAdapter : PagingDataAdapter<UserModel, UsersAdapter.UserVH>(UserDiffCallBack()) {
    inner class UserVH(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UserModel) {
            with(binding) {
                Glide.with(ivUser.context).load(model.avatar).into(ivUser)
                tvEmail.text = model.email
                tvFirstName.text = model.firstName
                tvLastName.text = model.lastName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(getItem(position)!!)
    }
}