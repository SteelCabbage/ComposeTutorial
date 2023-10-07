package com.baicai.composetutorial.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@Composable
fun PageMine() {
    val pageName = "个人中心"
    val context = LocalContext.current
    val dialogVisible = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF4FC1E9))
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
        AnimateDpAsStateTest(dialogVisible)
        AddDialog(dialogVisible)
    }
}

@Composable
fun AnimateDpAsStateTest(dialogVisible: MutableState<Boolean>) {
    Text(
        text = "Animate",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(100.dp)
            .background(color = Color(0xFF48CFAD))
            .clickable {
                dialogVisible.value = true
            }
    )
}

@Composable
fun AddDialog(dialogVisible: MutableState<Boolean>) {
    val context = LocalContext.current
    if (dialogVisible.value) {
        Dialog(onDismissRequest = {
            dialogVisible.value = false
            toastText(context, "弹窗关闭了")
        }, content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(280.dp)
                    .height(100.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                Text("弹窗测试")
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun PageMinePreview() {
    PageMine()
}
