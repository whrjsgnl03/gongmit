package com.example.gongmit

import android.graphics.Color as AndroidColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gongmit.ui.theme.GongmitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                AndroidColor.TRANSPARENT,   // 배경 투명
                AndroidColor.TRANSPARENT    // 기기가 다크모드일 때 배경
            )
        )
        setContent {
            GongmitTheme {
                AppNavigator()
            }
        }
    }
}