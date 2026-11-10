package com.example.gongmit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.gongmit.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
    Font(R.font.pretendard_black, FontWeight.Black)
)

private val Default = Typography()

// 앱 전체 기본 글씨체를 Pretendard로
val Typography = Typography(
    displayLarge = Default.displayLarge.copy(fontFamily = Pretendard),
    displayMedium = Default.displayMedium.copy(fontFamily = Pretendard),
    displaySmall = Default.displaySmall.copy(fontFamily = Pretendard),
    headlineLarge = Default.headlineLarge.copy(fontFamily = Pretendard),
    headlineMedium = Default.headlineMedium.copy(fontFamily = Pretendard),
    headlineSmall = Default.headlineSmall.copy(fontFamily = Pretendard),
    titleLarge = Default.titleLarge.copy(fontFamily = Pretendard),
    titleMedium = Default.titleMedium.copy(fontFamily = Pretendard),
    titleSmall = Default.titleSmall.copy(fontFamily = Pretendard),
    bodyLarge = Default.bodyLarge.copy(fontFamily = Pretendard),
    bodyMedium = Default.bodyMedium.copy(fontFamily = Pretendard),
    bodySmall = Default.bodySmall.copy(fontFamily = Pretendard),
    labelLarge = Default.labelLarge.copy(fontFamily = Pretendard),
    labelMedium = Default.labelMedium.copy(fontFamily = Pretendard),
    labelSmall = Default.labelSmall.copy(fontFamily = Pretendard)
)
