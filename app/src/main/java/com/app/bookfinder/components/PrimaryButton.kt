package com.app.bookfinder.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.ThemeStyle

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = BookFinderTheme.colors.buttonBackground,
            contentColor = BookFinderTheme.colors.buttonText
        )
    ) {
        Text(
            text = text,
            style = BookFinderTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.WINE) {
        PrimaryButton(
            text = "Entrar",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}