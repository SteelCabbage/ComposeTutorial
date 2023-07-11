package com.baicai.composetutorial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * @author liuyi@qingting.fm
 * @date 2023/07/11
 */
class MainViewModel : ViewModel() {

    var selectedTab by mutableStateOf(0)
}