package com.ardev.proadts.models.response.user

import com.ardev.proadts.base.BaseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchUserResponse(
    @Json(name = "total_count")
    var totalCount: Int? = null,

    @Json(name = "incomplete_results")
    var incompleteResults: Boolean? = null,

    @Json(name = "items")
    var items: List<UserResponse>? = null,

    ): BaseModel() {
    companion object {
        fun empty() = SearchUserResponse()
    }
}
