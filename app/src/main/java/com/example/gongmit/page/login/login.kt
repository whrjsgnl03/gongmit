package com.example.gongmit.page.login

import android.R.color.black
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.gongmit.ui.theme.GongmitTheme
import com.example.gongmit.ui.theme.Pretendard

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onGoogleLoginClick: () -> Unit = {},
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F4EC))
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(72.dp))

            Image(
                painter = painterResource(R.drawable.home_grass),
                contentDescription = "Logo",
                modifier = Modifier.width(340.dp)
            )

            Text(
                text = "공밋",
                color = Color.Black,
                fontFamily = Pretendard,
                fontWeight = ExtraBold,
                fontSize = 66.sp,
                modifier = Modifier.padding(top = 36.dp).align(Alignment.Start)
            )

            Text(
                text = "오늘의 공부를 커밋하자",
                color = Color.Black,
                fontFamily = Pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 6.dp).align(Alignment.Start)
            )

            Text(
                text = "대마고 친구들과 공부 시간을 재고, 학과와 반끼리 겨뤄요.",
                color = Color(0xFF4F5B52),
                fontFamily = Pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 15.dp).align(Alignment.Start)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onGoogleLoginClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .height(57.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "Google 계정으로 계속하기",
                    color = Color.Black,
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 15.dp),
                )
            }
            Column(
                modifier = Modifier.padding(bottom = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "대마고 재학생만 쓸 수 있어요.",
                    color = Color(0xFF4F5B52),
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                )
                Text(
                    text = "처음이면 로그인한 뒤 프로필을 설정해요.",
                    color = Color(0xFF4F5B52),
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                )
            }
        }
    }
}

@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            LoginScreen()
        }
    }
}

@Preview(name = "Pixel 4", device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun LoginScreenPixel4Preview() {
    GongmitTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.three),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize().alpha(0.5f)
            )
            LoginScreen()
        }
    }
}
