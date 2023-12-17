package com.example.hw18.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.hw18.models.UserModel
import com.example.hw18.paging.UserPagingSource
import kotlinx.coroutines.flow.Flow

class UsersViewModel : ViewModel() {
    val users: Flow<PagingData<UserModel>> = Pager(
        config = PagingConfig(
            pageSize = 6,
            prefetchDistance = 2,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { UserPagingSource() }
    ).flow.cachedIn(viewModelScope)
}