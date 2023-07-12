package com.baicai.composetutorial.bean

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */
data class Channel(val title: String) : CommonData {

    override fun type(): Int {
        return 1
    }

    override fun title(): String {
        return title
    }
}
