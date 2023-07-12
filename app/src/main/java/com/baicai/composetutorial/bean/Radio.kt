package com.baicai.composetutorial.bean

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/12
 */
data class Radio(val title: String) : CommonData {

    override fun type(): Int {
        return 0
    }

    override fun title(): String {
        return title
    }
}
