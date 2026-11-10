package com.example.gongmit.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gongmit.page.home.GrassGrid
import com.example.gongmit.ui.theme.Pretendard
import javax.security.auth.Subject

@Composable
fun Subject_Button(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .background(Color(0xFFFFFFFF), RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFDADFD2), RoundedCornerShape(16.dp)),
        Alignment.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontFamily = Pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "1:24",
                fontFamily = Pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun Subject_ButtonPreview() {
    Subject_Button(
        text = "과학",
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(end = 5.dp),
        isSelected = true
    )
}