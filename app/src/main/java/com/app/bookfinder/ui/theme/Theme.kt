package com.app.bookfinder.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

enum class ThemeStyle {
    WINE, BEIGE, GRAY, ROSEWOOD, GREEN
}
@Stable
data class BookFinderColors(
    val screenBackground: Color,
    val screenText: Color,
    val buttonBackground: Color,
    val buttonText: Color,
    val inputBackground: Color,
    val cardBackground: Color
)

val WineColorScheme = BookFinderColors(
    screenBackground = BrandWine,
    screenText = BrandBeige,
    buttonBackground = BrandWine,
    buttonText = BrandBeige,
    inputBackground = NeutralGrayAlpha45,
    cardBackground = BrandBeige
)

val BeigeColorScheme = BookFinderColors(
    screenBackground = BrandBeige,
    screenText = BrandWine,
    buttonBackground = BrandWine,
    buttonText = BrandBeige,
    inputBackground = NeutralGrayAlpha45,
    cardBackground = BrandBeige
)

val GrayColorScheme = BookFinderColors(
    screenBackground = NeutralGray,
    screenText = BrandBeige,
    buttonBackground = BrandWine,
    buttonText = BrandBeige,
    inputBackground = NeutralGrayAlpha45,
    cardBackground = BrandBeige
)

val RosewoodColorScheme = BookFinderColors(
    screenBackground = BrandRosewood,
    screenText = BrandWine,
    buttonBackground = BrandWine,
    buttonText = BrandBeige,
    inputBackground = NeutralGrayAlpha45,
    cardBackground = BrandBeige
)

val GreenColorScheme = BookFinderColors(
    screenBackground = BrandGreen,
    screenText = BrandWine,
    buttonBackground = BrandWine,
    buttonText = BrandBeige,
    inputBackground = BrandBeige,
    cardBackground = BrandBeige
)

val LocalBookFinderColors = staticCompositionLocalOf { WineColorScheme }

object BookFinderTheme {
    val colors: BookFinderColors
        @Composable
        get() = LocalBookFinderColors.current
    val typography: androidx.compose.material3.Typography
        @Composable
        get() = Typography
}
@Composable
fun BookFinderTheme(
    themeStyle: ThemeStyle = ThemeStyle.WINE,
    content: @Composable () -> Unit
) {

    val colorScheme = when (themeStyle) {
        ThemeStyle.WINE -> WineColorScheme
        ThemeStyle.BEIGE -> BeigeColorScheme
        ThemeStyle.GRAY -> GrayColorScheme
        ThemeStyle.ROSEWOOD -> RosewoodColorScheme
        ThemeStyle.GREEN -> GreenColorScheme
    }

    MaterialTheme(
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalBookFinderColors provides colorScheme
            ) {
                content()
            }
        }
    )
}