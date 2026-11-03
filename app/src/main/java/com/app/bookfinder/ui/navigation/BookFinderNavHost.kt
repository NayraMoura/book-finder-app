package com.app.bookfinder.ui.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.bookfinder.data.local.BookFinderDatabase
import com.app.bookfinder.data.repository.UserRepository
import com.app.bookfinder.ui.screens.LoginScreen
import com.app.bookfinder.ui.screens.LoginViewModel
import com.app.bookfinder.ui.screens.LoginViewModelFactory
import com.app.bookfinder.ui.screens.SearchScreen

@Composable
fun BookFinderNavHost() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val database = BookFinderDatabase.getDatabase(context)
    val repository = UserRepository(database.userDao())

    NavHost(navController = navController, startDestination = Routes.LOGIN) {

        composable(Routes.LOGIN) {
            val viewModel: LoginViewModel = viewModel(
                factory = LoginViewModelFactory(repository)
            )
            val lastUser by viewModel.lastUser.collectAsState(initial = null)

            LoginScreen(
                initialUsername = lastUser ?: "",
                onLoginClick = { username, password ->
                    val safeName = if (username.isNotBlank()) username.trim() else "Leitor"

                    viewModel.onLogin(safeName) { savedName ->
                        val encodedName = Uri.encode(savedName)
                        navController.navigate(Routes.createSearchRoute(encodedName)) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                        }
                    }
                },
                onRegisterClick = { }
            )
        }

        composable(Routes.SEARCH) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""

            SearchScreen(
                username = username,
                onNavigateBack = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SEARCH) { inclusive = true }
                    }
                },
                onNextClick = {}
            )
        }
    }
}