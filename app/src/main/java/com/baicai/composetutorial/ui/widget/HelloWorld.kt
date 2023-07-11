package com.baicai.composetutorial.ui.widget

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author liuyi@qingting.fm
 * @date 2023/07/11
 */

@Composable
fun HelloWorld(str: String) {
    val context = LocalContext.current
    Text(
        text = "$str! Hello～～",
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color(0xFF00FF00), shape = RoundedCornerShape(5.dp, 10.dp, 0.dp, 5.dp))
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom)
            .padding(5.dp)
            .clickable { showToast(context, "hahahaha") }
    )
}

private fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    HelloWorld("Hi~~~")
}