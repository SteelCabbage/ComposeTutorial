package com.baicai.composetutorial.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.baicai.composetutorial.R
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@Composable
fun PageVip() {
    val pageName = "超级会员"
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFCE54))
    ) {
        Text(
            text = pageName,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    toastText(context, pageName)
                }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.rabbit),
            contentScale = ContentScale.Crop,
            contentDescription = "本地兔子",
            modifier = Modifier
                .size(200.dp)
                .clip(
//                    shape = RoundedCornerShape(15.dp)
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            model = "https://img1.baidu.com/it/u=1707686077,3070250178&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
            contentDescription = "网络兔子",
            modifier = Modifier
                .size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageVipPreview() {
    PageVip()
}
