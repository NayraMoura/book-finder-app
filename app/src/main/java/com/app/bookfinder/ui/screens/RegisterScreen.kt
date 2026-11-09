package com.app.bookfinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookfinder.R
import com.app.bookfinder.components.BookFinderTextField
import com.app.bookfinder.components.PrimaryButton
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.ThemeStyle
import com.app.bookfinder.viewmodels.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel,
    onNavigateBack: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    RegisterScreenContent(
        name = viewModel.name,
        onNameChange = viewModel::onNameChange,
        email = viewModel.email,
        onEmailChange = viewModel::onEmailChange,
        password = viewModel.password,
        onPasswordChange = viewModel::onPasswordChange,
        confirmPassword = viewModel.confirmPassword,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onRegisterClick = { viewModel.registerUser(onRegisterSuccess) },
        onNavigateBack = onNavigateBack
    )
}
@Composable
fun RegisterScreenContent(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BookFinderTheme.colors.screenBackground)
    ) {

        Image(
            painter = painterResource(id = R.drawable.beige_back_arrow),
            contentDescription = "Voltar",
            modifier = Modifier
                .padding(start = 24.dp, top = 40.dp)
                .size(32.dp)
                .align(Alignment.TopStart)
                .clickable { onNavigateBack() },
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(BookFinderTheme.colors.cardBackground)
                        .padding(start = 24.dp, end = 24.dp, top = 50.dp, bottom = 97.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    BookFinderTextField(
                        value = name,
                        onValueChange = onNameChange,
                        placeholder = "nome ou apelido",
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BookFinderTextField(
                        value = email,
                        onValueChange = onEmailChange,
                        placeholder = "e-mail",
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BookFinderTextField(
                        value = password,
                        onValueChange = onPasswordChange,
                        placeholder = "crie uma senha",
                        isPassword = true,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BookFinderTextField(
                        value = confirmPassword,
                        onValueChange = onConfirmPasswordChange,
                        placeholder = "confirme sua senha",
                        isPassword = true,
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    PrimaryButton(
                        text = "Cadastrar",
                        onClick = onRegisterClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.two_books),
                    contentDescription = "Livros",
                    modifier = Modifier
                        .size(width = 400.dp, height = 85.dp)
                        .offset(x = 95.dp, y = (-10).dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.coffee_mug),
                    contentDescription = "Café",
                    modifier = Modifier
                        .size(width = 50.dp, height = 75.dp)
                        .offset(x = 100.dp, y = (-35).dp)
                )

                Box(
                    modifier = Modifier
                        .matchParentSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.messy_books),
                        contentDescription = "Livros bagunçados",
                        modifier = Modifier
                            .size(width = 120.dp, height = 100.dp)
                            .offset(y = 23.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.GRAY) {
        RegisterScreenContent(
            name = "",
            onNameChange = {},
            email = "",
            onEmailChange = {},
            password = "",
            onPasswordChange = {},
            confirmPassword = "",
            onConfirmPasswordChange = {},
            onRegisterClick = {},
            onNavigateBack = {}
        )
    }
}