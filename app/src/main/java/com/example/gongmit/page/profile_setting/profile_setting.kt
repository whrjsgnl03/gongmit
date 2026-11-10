package com.example.gongmit.page.profile_setting

import android.R.color.black
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.gongmit.ui.component.Class_Button
import com.example.gongmit.ui.component.Department_Button
import com.example.gongmit.ui.component.Grade_Button
import com.example.gongmit.ui.theme.GongmitTheme
import com.example.gongmit.ui.theme.Pretendard

@Composable
fun Profile_Setting_Screen(
    modifier: Modifier = Modifier,
    onLoginClick: (id: String, password: String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {},
    onStartClick: () -> Unit = {}
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var selectedGrade by remember { mutableStateOf(2) }
    var selectedDepartment by remember { mutableStateOf("소프트웨어개발과") }
    var selectedClass by remember { mutableStateOf(1) }

    val array = arrayOf("소프트웨어개발과", "임베디드소프트웨어과", "인공지능소프트웨어과")

    var enabled = selectedDepartment == array.first()

    var my_department = selectedDepartment

    var name by remember { mutableStateOf("김이름") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F4EC))
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 56.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "프로필 설정",
                        color = Color.Black,
                        fontFamily = Pretendard,
                        fontWeight = ExtraBold,
                        fontSize = 29.sp,
                    )
                    Text(
                        text = "랭킹과 공밋 리그에 쓰이는 정보예요.",
                        color = Color(0xFF4F5B52),
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 2.dp),
                    )
                }
                Row(
                    modifier =
                        Modifier
                            .padding(top = 16.dp)
                            .height(85.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDADFD2),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(16.dp)
                            ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_photo),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(40.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .padding(vertical = 12.dp)
                            .fillMaxHeight()
                            .align(Alignment.Top)
                    ) {
                        Text(
                            text = "랭킹에는 이렇게 보여요",
                            color = Color(0xFF4F5B52),
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = name,
                            color = Color.Black,
                            fontFamily = Pretendard,
                            fontWeight = ExtraBold,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "$my_department ${selectedGrade}학년 ${selectedClass}반",
                            color = Color(0xFF4F5B52),
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(top = 0.dp),
                ) {
                    Text(
                        text = "닉네임",
                        color = Color(0xFF17201A),
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 20.dp)
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text("닉네임을 입력하세요") },  // 칸 안의 흐린 안내 글씨 (선택)
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFC9D0C0),
                            unfocusedBorderColor = Color(0xFFC9D0C0),
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp)
                            .height(52.dp),
                    )
                }
                Text(
                    text = "2~10자. 나중에 내 정보에서 바꿀 수 있어요.",
                    color = Color(0xFF4F5B52),
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "학과",
                        color = Color(0xFF17201A),
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 15.dp)
                    )
                    array.forEach { department ->
                        Department_Button(
                            text = department,
                            onClick = {
                                selectedDepartment = department
                                my_department = selectedDepartment
                            },
                            isNotClicked = selectedDepartment != department
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(top = 15.dp).weight(0.8f)
                    ) {
                        Text(
                            text = "학년",
                            color = Color(0xFF17201A),
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .align(Alignment.Start)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp, end = 10.dp)
                                .height(50.dp)
                                .background(Color(0xFFE3E8DA), RoundedCornerShape(12.dp))
                                .border(1.dp, Color(0xFFDADFD2), RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                listOf(2, 3).forEach { grade ->
                                    Grade_Button(
                                        text = "${grade}학년",
                                        isSelected = selectedGrade == grade,
                                        onClick = { selectedGrade = grade },
                                        modifier = Modifier
                                            .weight(1f)
                                            .align(Alignment.CenterVertically)
                                            .height(40.dp)
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.padding(top = 15.dp).weight(1f)
                    ) {
                        Text(
                            text = "반",
                            color = Color(0xFF17201A),
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp, end = 10.dp)
                                .height(50.dp)
                                .background(Color(0xFFE3E8DA), RoundedCornerShape(12.dp))
                                .border(1.dp, Color(0xFFDADFD2), RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                listOf(1, 2).forEach { Class ->
                                    Class_Button(
                                        text = "${Class}반",
                                        isSelected = selectedClass == Class,
                                        onClick = { selectedClass = Class },
                                        modifier = Modifier
                                            .weight(1f)
                                            .align(Alignment.CenterVertically)
                                            .height(40.dp),
                                        enabled = enabled
                                    )
                                }
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .height(150.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        onClick = onStartClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B7A16)),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(57.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = "공밋 시작하기",
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

@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun Profile_Setting_ScreenPreview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Profile_Setting_Screen()
        }
    }
}

@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun Profile_Setting_ScreenPixel4Preview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.two),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize().alpha(0.5f)
            )
            Profile_Setting_Screen(modifier = Modifier.alpha(0.5f))
        }
    }
}
