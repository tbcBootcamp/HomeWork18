package com.example.hw18.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hw18.models.UserModel

class UserDiffCallBack : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}