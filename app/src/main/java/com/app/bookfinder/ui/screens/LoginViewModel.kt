package com.app.bookfinder.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.bookfinder.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    private val _lastUser = MutableStateFlow<String?>(null)
    val lastUser: StateFlow<String?> = _lastUser.asStateFlow()

    init {
        loadLastUser()
    }

    private fun loadLastUser() {
        viewModelScope.launch {
            _lastUser.value = repository.getLastLoggedUser()?.username
        }
    }

    fun onLogin(username: String, onSuccess: (String) -> Unit) {
        viewModelScope.launch {
            repository.saveUser(username)
            onSuccess(username)
        }
    }
}

class LoginViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}