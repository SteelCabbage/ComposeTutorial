package com.baicai.composetutorial.bean

import androidx.compose.runtime.Stable

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */
@Stable
interface CommonData {

    fun type(): DataType
    fun title(): String
}