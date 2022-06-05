package com.ardev.proadts.models.response.user

import com.ardev.proadts.base.BaseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class UserResponse(
    @Json(name = "login")
    var login: String? = null,

    @Json(name = "id")
    var id: Int? = null,

    @Json(name = "node_id")
    var nodeId: String? = null,

    @Json(name = "avatar_url")
    var avatarUrl: String? = null,

    @Json(name = "gravatar_id")
    var gravatarId: String? = null,

    @Json(name = "url")
    var url: String? = null,

    @Json(name = "html_url")
    var htmlUrl: String? = null,

    @Json(name = "followers_url")
    var followersUrl: String? = null,

    @Json(name = "following_url")
    var followingUrl: String? = null,

    @Json(name = "gists_url")
    var gistsUrl: String? = null,

    @Json(name = "starred_url")
    var starredUrl: String? = null,

    @Json(name = "subscriptions_url")
    var subscriptionsUrl: String? = null,

    @Json(name = "organizations_url")
    var organizationsUrl: String? = null,

    @Json(name = "repos_url")
    var reposUrl: String? = null,

    @Json(name = "events_url")
    var eventsUrl: String? = null,

    @Json(name = "received_events_url")
    var receivedEventsUrl: String? = null,

    @Json(name = "type")
    var type: String? = null,

    @Json(name = "site_admin")
    var siteAdmin: Boolean? = null,

    @Json(name = "score")
    var score: Double? = null,


    // Addition Model for Detail User
    @Json(name = "name")
    var name: String? = null,

    @Json(name = "company")
    var company: String? = null,

    @Json(name = "blog")
    var blog: String? = null,

    @Json(name = "location")
    var location: String? = null,

    @Json(name = "email")
    var email: String? = null,

    @Json(name = "bio")
    var bio: String? = null,

    @Json(name = "twitter_username")
    var twitterUsername: String? = null,

    @Json(name = "public_repos")
    var publicRepos: Int? = null,

    @Json(name = "public_gists")
    var publicGists: Int? = null,

    @Json(name = "followers")
    var followers: Int? = null,

    @Json(name = "following")
    var following: Int? = null,

    @Json(name = "created_at")
    var createdAt: String? = null,

    @Json(name = "updated_at")
    var updatedAt: String? = null,

): BaseModel() {

    companion object {
        fun empty() = UserResponse()
    }
}