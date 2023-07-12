package com.baicai.composetutorial.page

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baicai.composetutorial.ui.theme.QtStronger
import com.baicai.composetutorial.ui.theme.QtWeak
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageListen() {
    val pageName = "我听"
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF48CFAD))
    ) {
        Text(
            text = pageName,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    toastText(context, pageName)
                }
        )
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            value = textState.value,
            onValueChange = { str ->
                Log.i("baicai", "TextField onValueChange=$str")
                textState.value = str
            },
            placeholder = {
                Text(text = "请输入你想听的吧～", color = QtWeak)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = QtStronger,
                containerColor = Color(0xFF37BC9B),
                cursorColor = Color(0xFFF6BB42),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
//                disabledIndicatorColor = Color.Transparent,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageListenPreview() {
    PageListen()
}
