package com.baicai.composetutorial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.baicai.composetutorial.bean.Channel
import com.baicai.composetutorial.bean.CommonData
import com.baicai.composetutorial.bean.Radio

/**
 * @author liuyi@qingting.fm
 * @date 2023/07/11
 */
class MainViewModel : ViewModel() {

    var selectedTab by mutableStateOf(0)

    val dataMap = mutableStateMapOf<String, CommonData>()

    val dataList = mutableStateListOf<CommonData>()

    fun generateData() {
        for (i in 0 until 100) {
            val commonData = if (i % 2 == 0) {
                Radio(
                    title = "我是第${i}只兔子的广播, 啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦",
                    url = "https://img1.baidu.com/it/u=1707686077,3070250178&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                )
            } else {
                Channel(
                    title = "我是第${i}只狐狸的专辑, 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
                    url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F10%2F20160310070550_j5LfM.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1691809220&t=3f24f916fd5e8e97de5007da3b848eec"
                )
            }
            dataList.add(commonData)
        }
    }
}