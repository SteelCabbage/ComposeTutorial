package com.baicai.composetutorial.bean

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */
data class Radio(
    val title: String? = null,
    val url: String? = null
) : CommonData {

    override fun type(): DataType {
        return DataType.RADIO
    }

    override fun title(): String {
        return title ?: ""
    }
}
