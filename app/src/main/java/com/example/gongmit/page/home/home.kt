
package com.example.gongmit.page.home

import android.R.color.black
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gongmit.R
import com.example.gongmit.page.profile_setting.Profile_Setting_Screen
import com.example.gongmit.ui.component.Subject_Button
import com.example.gongmit.ui.theme.GongmitTheme
import com.example.gongmit.ui.theme.Pretendard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onGoogleLoginClick: () -> Unit = {},
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F4EC))
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "공밋",
                            fontFamily = Pretendard,
                            fontWeight = ExtraBold,
                            fontSize = 23.sp,
                            color = Color(0xFF17201A),
                            modifier = Modifier.padding(top = 30.dp)
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .width(96.dp)
                                .height(33.dp)
                                .background(
                                    Color(0xFFFFFFFF),
                                    RoundedCornerShape(15.dp)
                                )
                                .border(
                                    1.dp, Color(0xFFDADFD2),
                                    RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .background(
                                            Color(0xFF3B7A16),
                                            RoundedCornerShape(3.dp)
                                        )
                                )
                                Text(
                                    text = "12일 연속",
                                    fontFamily = Pretendard,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = Color(0xFF17201A),
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Text(
                            text = "오늘의 공밋",
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color(0xFF4F5B52),
                        )
                        Text(
                            text = "3시간 46분",
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 46.sp,
                        )
                        Text(
                            text = "어제 이 시간보다 38분 더 했어요",
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = Color(0xFF4F5B52),
                        )
                    }
                    Column(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Row() {
                            Text(
                                text = "공부잔디",
                                fontFamily = Pretendard,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 5.dp, top = 5.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(end = 0.dp)
                            ) {
                                Text(
                                    text = "적게",
                                    fontFamily = Pretendard,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 13.sp,
                                    color = Color(0xFF4F5B52),
                                )
                                Image(
                                    painter = painterResource(R.drawable.group_1__1_),
                                    contentDescription = null,
                                )
                                Text(
                                    text = "많이",
                                    fontFamily = Pretendard,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 13.sp,
                                    color = Color(0xFF4F5B52),
                                )
                            }
                        }
                        GrassGrid(
                            studyMinutes = List(126) { 0 }
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 15.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .background(Color(0xFFFFFFFF), RoundedCornerShape(16.dp))
                            .border(1.dp, Color(0xFFDADFD2), RoundedCornerShape(16.dp)),
                        Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 17.dp)
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF4E9A1E))
                            )
                            Column(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Text(
                                    text = "지금 23명 공부 중",
                                    fontFamily = Pretendard,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp,
                                )
                                Text(
                                    text = "우리 반에서는 4명",
                                    fontFamily = Pretendard,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(end = 19.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(35.dp)
                                            .background(
                                                Color(0xFFCFE6A1),
                                                RoundedCornerShape(10.dp)
                                            )
                                            .border(
                                                2.dp,
                                                Color(0xFFFFFFFF),
                                                RoundedCornerShape(10.dp)
                                            ),
                                    ) {
                                        Text(
                                            text = "코",
                                            fontFamily = Pretendard,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Color(0xFF17201A),
                                            modifier = Modifier.align(Alignment.Center)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(start = 25.dp)
                                            .size(35.dp)
                                            .background(
                                                Color(0xFFA5D05A),
                                                RoundedCornerShape(10.dp)
                                            )
                                            .border(
                                                2.dp,
                                                Color(0xFFFFFFFF),
                                                RoundedCornerShape(10.dp)
                                            ),
                                    ) {
                                        Text(
                                            text = "새",
                                            fontFamily = Pretendard,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Color(0xFF17201A),
                                            modifier = Modifier.align(Alignment.Center)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(start = 50.dp)
                                            .size(35.dp)
                                            .background(
                                                Color(0xFF6FAE2A),
                                                RoundedCornerShape(10.dp)
                                            )
                                            .border(
                                                2.dp,
                                                Color(0xFFFFFFFF),
                                                RoundedCornerShape(10.dp)
                                            ),
                                    ) {
                                        Text(
                                            text = "정",
                                            fontFamily = Pretendard,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Color(0xFF17201A),
                                            modifier = Modifier.align(Alignment.Center)
                                        )
                                    }
                                }
                                Image(
                                    painter = painterResource(R.drawable.group__4_),
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 20.dp)
                                )
                            }
                        }
                    }
                    Column() {
                        Text(
                            text = "무엇을 공부할까요?",
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 25.dp, bottom = 4.dp)
                        )
                        Column() {
                            Row() {
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(0.5f)
                                        .padding( end = 5.dp),
                                    isSelected = true
                                )
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(1f)
                                        .padding( start = 5.dp),
                                    isSelected = true
                                )
                            } //
                            Row(
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(0.5f)
                                        .padding( end = 5.dp),
                                    isSelected = true
                                )
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(1f)
                                        .padding( start = 5.dp),
                                    isSelected = true
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 8.dp)

                            ) {
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(0.5f)
                                        .padding( end = 5.dp),
                                    isSelected = true
                                )
                                Subject_Button(
                                    "전공",
                                    modifier = modifier
                                        .fillMaxWidth(1f)
                                        .padding( start = 5.dp),
                                    isSelected = true
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize().padding(top = 40.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B7A16)),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(57.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.vector__11_),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Text(
                            text = "코딩 공부 시작",
                            color = Color.White,
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GrassGrid(
    studyMinutes: List<Int>,   // 날짜 순서대로 하루 공부 시간(분)
    modifier: Modifier = Modifier,
) {
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        studyMinutes.chunked(7).forEach { week ->   // 7일씩 끊어서 세로줄 하나로
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                week.forEach { minutes ->
                    Box(
                        Modifier
                            .size(15.dp)
                            .background(grassColor(minutes), RoundedCornerShape(3.dp))
                    )
                }
            }
        }
    }
}

private fun grassColor(minutes: Int): Color = when {
    minutes == 0 -> Color(0xFFE3E8DA)
    minutes < 30 -> Color(0xFFC6E48B)
    minutes < 60 -> Color(0xFF7BC96F)
    minutes < 120 -> Color(0xFF239A3B)
    else -> Color(0xFF196127)
}

@Preview
@Composable
fun GrassGridPreview() {
    GrassGrid(listOf())
}
@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            HomeScreen()
        }
    }
}

@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HomeScreenPixel4Preview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            HomeScreen()
            Image(
                painter = painterResource(R.drawable.three),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize().alpha(0.5f)
            )
        }
    }
}
