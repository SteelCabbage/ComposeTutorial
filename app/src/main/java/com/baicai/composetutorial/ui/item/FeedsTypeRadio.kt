package com.baicai.composetutorial.ui.item

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.baicai.composetutorial.TAG
import com.baicai.composetutorial.bean.CommonData
import com.baicai.composetutorial.bean.Radio
import com.baicai.composetutorial.ui.theme.QtStronger

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */

@Composable
fun FeedsTypeRadio(commonData: CommonData) {
    Log.d(TAG, "FeedsTypeRadio title=${commonData.title()}")
    val radio = commonData as? Radio ?: return
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp, 10.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(0xFFF08080))
                .weight(1F)
        ) {
            Text(
                text = radio.title ?: "",
                textAlign = TextAlign.End,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = QtStronger,
                modifier = Modifier
                    .wrapContentWidth()
                    .background(Color(0xFFFFDAB9))
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            model = radio.url,
            contentDescription = radio.title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeedsTypeRadioPreview() {
    val radio = Radio(
        title = "兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪兔朱迪",
        url = "https://img1.baidu.com/it/u=1707686077,3070250178&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
    )
    FeedsTypeRadio(radio)
}