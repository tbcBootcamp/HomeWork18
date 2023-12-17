package com.example.hw18.models

import com.squareup.moshi.Json

data class PageModel(
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int?,
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    val data: List<UserModel>
)