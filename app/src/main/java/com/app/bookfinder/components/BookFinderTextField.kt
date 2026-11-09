package com.app.bookfinder.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.ThemeStyle

@Composable
fun BookFinderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = BookFinderTheme.colors.screenText.copy(alpha = 0.7f),
                style = BookFinderTheme.typography.bodyLarge,
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(30.dp),
        singleLine = true,
        textStyle = BookFinderTheme.typography.bodyLarge.copy(
            color = BookFinderTheme.colors.screenText,
        ),
        visualTransformation = if (isPassword && !passwordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            if (isPassword) {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Ocultar senha" else "Mostrar senha"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = image,
                        contentDescription = description,
                        tint = BookFinderTheme.colors.screenText.copy(alpha = 0.7f)
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = BookFinderTheme.colors.inputBackground,
            unfocusedContainerColor = BookFinderTheme.colors.inputBackground,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = BookFinderTheme.colors.screenText,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun BookFinderTextFieldPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.WINE) {
        BookFinderTextField(
            value = "",
            onValueChange = {},
            placeholder = "usuário",
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookFinderPasswordTextFieldPreview() {
    BookFinderTheme(themeStyle = ThemeStyle.BEIGE) {
        BookFinderTextField(
            value = "minhasenha123",
            onValueChange = {},
            placeholder = "senha",
            isPassword = true,
            modifier = Modifier.padding(16.dp),
        )
    }
}