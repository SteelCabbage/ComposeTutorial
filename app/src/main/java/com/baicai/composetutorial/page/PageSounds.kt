package com.baicai.composetutorial.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.baicai.composetutorial.ADD_POSITION_FIRST
import com.baicai.composetutorial.MainViewModel
import com.baicai.composetutorial.bean.DataType
import com.baicai.composetutorial.ui.item.FeedsTypeChannel
import com.baicai.composetutorial.ui.item.FeedsTypeRadio
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@Composable
fun PageSounds() {
    val pageName = "声界"
    val context = LocalContext.current
    val viewModel: MainViewModel = viewModel()
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFA0D468))
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
        Text(
            text = "点击头像, 发消息～点击文字清空消息",
            modifier = Modifier
                .clickable {
                    viewModel.dataList.clear()
                }
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AsyncImage(
                model = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F10%2F20160310070550_j5LfM.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1691809220&t=3f24f916fd5e8e97de5007da3b848eec",
                contentDescription = "网络狐狸",
                modifier = Modifier
                    .clickable {
                        viewModel.sendMsg(DataType.CHANNEL, ADD_POSITION_FIRST)
                    }
                    .size(60.dp)
            )
            AsyncImage(
                model = "https://img1.baidu.com/it/u=1707686077,3070250178&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
                contentDescription = "网络兔子",
                modifier = Modifier
                    .clickable {
                        viewModel.sendMsg(DataType.RADIO)
                    }
                    .size(60.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(viewModel.dataList, key = { it.title() }) { commonData ->
                when (commonData.type()) {
                    DataType.RADIO -> {
                        FeedsTypeRadio(commonData)
                    }

                    DataType.CHANNEL -> {
                        FeedsTypeChannel(commonData)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageSoundsPreview() {
    PageSounds()
}
