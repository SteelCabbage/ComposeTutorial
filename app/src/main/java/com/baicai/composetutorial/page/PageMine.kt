package com.baicai.composetutorial.page

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
        AnimateDpAsStateTest()
    }
}

@Composable
fun AnimateDpAsStateTest() {
    var big by remember { mutableStateOf(false) }

    val size = remember(big) { if (big) 200.dp else 100.dp }

    val anim1 by animateDpAsState(targetValue = size, label = "anim1")

    val anim2 = remember { Animatable(size, Dp.VectorConverter) }

    val anim3 = remember { Animatable(size, Dp.VectorConverter) }

//    LaunchedEffect(big) {
//        anim2.snapTo(if (big) 300.dp else 50.dp)
//        anim2.animateTo(size)
//    }

    LaunchedEffect(big) {
        anim3.animateTo(
            size,
            tween(
                durationMillis = 3000,
                delayMillis = 1000,
                easing = LinearEasing
            )
        )
    }

    Text(
        text = "Animate",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(anim3.value)
            .background(color = Color(0xFF48CFAD))
            .clickable {
                big = !big
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PageMinePreview() {
    PageMine()
}
