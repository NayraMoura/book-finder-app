package com.app.bookfinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookfinder.R
import com.app.bookfinder.components.PrimaryButton
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.ThemeStyle
import com.app.bookfinder.ui.theme.BrandGreen
import com.app.bookfinder.ui.theme.BrandWine

@Composable
fun SearchScreen(
    username: String,
    onNavigateBack: () -> Unit,
    onNextClick: () -> Unit
) {
    BookFinderTheme(themeStyle = ThemeStyle.BEIGE) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BookFinderTheme.colors.screenBackground)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botão de Voltar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.red_back_arrow),
                    contentDescription = "Voltar",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onNavigateBack() }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Olá, $username!",
                style = BookFinderTheme.typography.displayLarge,
                color = BookFinderTheme.colors.screenText
            )

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(BrandGreen)
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Responda as perguntas a seguir, para que eu te guie com sucesso nessa busca literária",
                    style = BookFinderTheme.typography.displayLarge,
                    color = BookFinderTheme.colors.cardBackground,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Você pode clicar em mais de uma opção, se precisar",
                style = BookFinderTheme.typography.bodyLarge,
                color = BrandWine,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))


            Image(
                painter = painterResource(id = R.drawable.cat_turtle_illustration),
                contentDescription = "Gatinha escaminha/tartaruga",
                modifier = Modifier
                    .size(width = 140.dp, height = 95.dp)
                    .offset(x = 10.dp, y = (-10).dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Avançar",
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.two_books),
                contentDescription = "Pilha de livros",
                modifier = Modifier
                    .size(width = 140.dp, height = 95.dp)
                    .offset(x = 8.dp, y = (80).dp)
            )

            Image(
                painter = painterResource(id = R.drawable.red_mug),
                contentDescription = "Caneca vermelha",
                modifier = Modifier
                    .size(width = 60.dp, height = 95.dp)
                    .offset(x = 18.dp, y = (-50).dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.BEIGE) {
        SearchScreen(
            username = "Maria",
            onNavigateBack = {},
            onNextClick = {}
        )
    }
}