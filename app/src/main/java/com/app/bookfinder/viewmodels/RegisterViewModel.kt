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

    var name by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var confirmPassword by mutableStateOf("")
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onNameChange(newName: String) { name = newName }
    fun onEmailChange(newEmail: String) { email = newEmail }
    fun onPasswordChange(newPassword: String) { password = newPassword }
    fun onConfirmPasswordChange(newConfirmPassword: String) { confirmPassword = newConfirmPassword }

    fun clearError() { errorMessage = null }
    fun registerUser(onSuccess: (String) -> Unit) {
        viewModelScope.launch {
            if (name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                errorMessage = "Por favor, preencha todos os campos."
                return@launch
            }

            if (password != confirmPassword) {
                errorMessage = "As senhas digitadas não coincidem."
                return@launch
            }

            if (password.length < 6) {
                errorMessage = "Sua senha deve ter pelo menos 6 caracteres."
                return@launch
            }

            try {
                val newUser = UserEntity(
                    username = name,
                    email = email,
                    password = password
                )
                repository.insertUser(newUser)

                onSuccess("Conta criada com sucesso! Faça login para continuar.")

            } catch (e: Exception) {
                errorMessage = "Erro ao criar conta. Tente novamente."
                e.printStackTrace()
            }
        }
    }
}

class RegisterViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}