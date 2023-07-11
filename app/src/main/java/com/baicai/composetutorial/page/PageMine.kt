package com.baicai.composetutorial.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@Composable
fun PageMine() {
    val pageName = "个人中心"
    val context = LocalContext.current
    Box(
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
    }
}

@Preview(showBackground = true)
@Composable
fun PageMinePreview() {
    PageMine()
}
