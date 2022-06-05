package com.ardev.proadts.models.response.user

import com.ardev.proadts.base.BaseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RepositoryResponse(

    @Json(name = "id")
    var id: Int? = null,

    @Json(name = "node_id")
    var nodeId: String? = null,

    @Json(name = "name")
    var name: String? = null,

    @Json(name = "full_name")
    var fullName: String? = null,

    @Json(name = "private")
    var private: Boolean? = null,

    @Json(name = "owner")
    var owner: UserResponse? = null,

    @Json(name = "html_url")
    var htmlUrl: String? = null,

    @Json(name = "description")
    var description: String? = null,

    @Json(name = "url")
    var url: String? = null,

    @Json(name = "created_at")
    var createdAt: String? = null,

    @Json(name = "updated_at")
    var updatedAt: String? = null,

    @Json(name = "pushed_at")
    var pushedAt: String? = null,

    @Json(name = "git_url")
    var gitUrl: String? = null,

    @Json(name = "clone_url")
    var cloneUrl: String? = null,

    @Json(name = "size")
    var size: Int? = null,

    @Json(name = "languange")
    var languange: String? = null,

    @Json(name = "default_branch")
    var defaultBranch: String? = null,

    @Json(name = "open_issues")
    var openIssues: String? = null,

) : BaseModel(){
    companion object {
        fun empty() = RepositoryResponse()
    }
}
