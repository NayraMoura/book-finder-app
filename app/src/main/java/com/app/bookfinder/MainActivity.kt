package com.app.bookfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.bookfinder.ui.navigation.BookFinderNavHost
import com.app.bookfinder.ui.theme.BookFinderTheme
import com.app.bookfinder.ui.theme.ThemeStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookFinderTheme(themeStyle = ThemeStyle.WINE) {
                BookFinderNavHost()
            }
        }
    }
}


