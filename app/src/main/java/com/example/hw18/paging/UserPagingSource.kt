package com.example.hw18.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hw18.models.UserModel
import com.example.hw18.network.RetrofitClient

class UserPagingSource() : PagingSource<Int, UserModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        val page = params.key ?: 1
        return try {
            val response = RetrofitClient.getPersonInfo.getUsers(page)
            val users = response.data
            Log.d("users Response", response.data.toString())
            LoadResult.Page(
                data = users,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (users.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}