package com.app.bookfinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookfinder.R
import com.app.bookfinder.components.BookFinderTextField
import com.app.bookfinder.components.PrimaryButton
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.BrandBeige
import com.app.bookfinder.ui.theme.BrandWine
import com.app.bookfinder.ui.theme.ThemeStyle

@Composable
fun LoginScreen(
    initialUsername: String = "",
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleClick: () -> Unit = {},
) {
    var username by remember(initialUsername) { mutableStateOf(initialUsername) }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BookFinderTheme.colors.screenBackground)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        // Title
        Text(
            text = "Seja Bem-Vindo(a) ao Book Finder!",
            style = BookFinderTheme.typography.displayLarge,
            color = BrandBeige,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Subtitle
        Text(
            text = "Faça login e me me deixe ajudar-lo(a) a encontrar um bom livro!",
            style = BookFinderTheme.typography.bodyLarge,
            color = BrandBeige,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp),
        )

        Spacer(modifier = Modifier.height(28.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            // Card Content Container
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(BrandBeige)
                    .padding(start = 24.dp, end = 24.dp, top = 50.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BookFinderTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "usuário",
                )

                Spacer(modifier = Modifier.height(16.dp))

                BookFinderTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "senha",
                    isPassword = true,
                )

                Spacer(modifier = Modifier.height(24.dp))

                PrimaryButton(
                    text = "Entrar",
                    onClick = { onLoginClick(username, password) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Não possui cadastro?",
                    style = BookFinderTheme.typography.bodyLarge,
                    color = BrandWine,
                )

                Spacer(modifier = Modifier.height(12.dp))

                PrimaryButton(
                    text = "Criar Conta",
                    onClick = onRegisterClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Se preferir, acesse com sua conta",
                    style = BookFinderTheme.typography.bodyLarge,
                    color = BrandWine,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "Google",
                        style = BookFinderTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = BrandWine,
                        ),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clickable { onGoogleClick() },
                    )

                    Image(
                        painter = painterResource(id = R.drawable.gray_lamp),
                        contentDescription = "Luminária",
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = 12.dp, y = 54.dp),
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 0.dp),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.stack_books),
                    contentDescription = "Pilha de livros",
                    modifier = Modifier
                        .size(width = 130.dp, height = 75.dp)
                        .offset(x = 40.dp, y = (-80).dp),
                )

                Image(
                    painter = painterResource(id = R.drawable.tuxedo_cat_illustration),
                    contentDescription = "Gatinha Frajola",
                    modifier = Modifier
                        .size(width = 130.dp, height = 180.dp)
                        .offset(x = (-25).dp, y = (-70).dp),
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.WINE) {
        LoginScreen(
            onLoginClick = { _, _ -> },
            onRegisterClick = {},
        )
    }
}
