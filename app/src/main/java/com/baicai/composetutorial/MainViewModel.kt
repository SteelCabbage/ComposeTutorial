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
                Channel("我是第${i}只兔子的专辑")
            } else {
                Radio("我是第${i}只兔子的广播")
            }
            dataList.add(commonData)
        }
    }
}