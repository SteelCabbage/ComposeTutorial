package com.baicai.composetutorial.ui.item

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.baicai.composetutorial.TAG
import com.baicai.composetutorial.bean.Channel
import com.baicai.composetutorial.bean.CommonData
import com.baicai.composetutorial.ui.theme.QtStronger

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */

@Composable
fun FeedsTypeChannel(commonData: CommonData) {
    Log.d(TAG, "FeedsTypeChannel title=${commonData.title()}")
    val channel = commonData as? Channel ?: return
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp, 10.dp).wrapContentSize()
    ) {
        AsyncImage(
            modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp)), model = channel.url, contentDescription = channel.title
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = channel.title ?: "",
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = QtStronger,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeedsTypeChannelPreview() {
    val channel = Channel(
        title = "狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克狐尼克",
        url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F10%2F20160310070550_j5LfM.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1691809220&t=3f24f916fd5e8e97de5007da3b848eec"
    )
    FeedsTypeChannel(channel)
}