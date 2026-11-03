package com.app.bookfinder.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.app.bookfinder.R

val JacquardFont = FontFamily(
    Font(R.font.jacquard24_regular, FontWeight.Normal)
)

val PoppinsFont = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal)
)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = JacquardFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        color = Color(0xFFFFE5B4)
    ),
    headlineMedium = TextStyle(
        fontFamily = JacquardFont,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color(0xFFFFE5B4)
    ),
    bodyLarge = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)