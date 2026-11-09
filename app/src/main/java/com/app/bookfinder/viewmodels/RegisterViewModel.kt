package com.app.bookfinder.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.bookfinder.data.local.UserEntity
import com.app.bookfinder.data.local.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: UserRepository) : ViewModel() {

    // Estados reativos que a UI vai observar
    var name by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var confirmPassword by mutableStateOf("")
        private set

    // Funções para atualizar o estado conforme o usuário digita
    fun onNameChange(newName: String) { name = newName }
    fun onEmailChange(newEmail: String) { email = newEmail }
    fun onPasswordChange(newPassword: String) { password = newPassword }
    fun onConfirmPasswordChange(newConfirmPassword: String) { confirmPassword = newConfirmPassword }

    // Lógica de persistência
    fun registerUser(onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && password == confirmPassword) {
                val newUser = UserEntity(
                    username = name,
                    email = email,
                    password = password
                )
                repository.insertUser(newUser)
                onSuccess()
            }
        }
    }
}

// Factory necessária para injetar o UserRepository no ViewModel
class RegisterViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}