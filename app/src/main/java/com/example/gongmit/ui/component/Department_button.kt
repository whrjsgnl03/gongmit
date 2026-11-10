package com.example.gongmit.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gongmit.R
import com.example.gongmit.ui.theme.Pretendard
import com.example.gongmit.ui.theme.selectColor
import com.example.gongmit.ui.theme.unselectColor


@Composable
fun Department_Button(
    text: String,
    onClick: () -> Unit,
    isNotClicked: Boolean = false
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (isNotClicked)
                    unselectColor
                else
                    selectColor
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(start = 16.dp),
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .padding(top = 6.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDADFD2),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(if (isNotClicked) R.drawable.button_false else R.drawable.button),
                contentDescription = "Dropdown Icon",
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = text,
                color = Color(0xFF17201A),
                fontFamily = Pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}