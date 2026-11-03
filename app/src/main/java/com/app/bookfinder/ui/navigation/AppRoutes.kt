package com.app.bookfinder.ui.navigation

object Routes {
    const val LOGIN = "login_screen"
    const val SEARCH = "search_screen/{username}"

    fun createSearchRoute(username: String) = "search_screen/$username"
}
