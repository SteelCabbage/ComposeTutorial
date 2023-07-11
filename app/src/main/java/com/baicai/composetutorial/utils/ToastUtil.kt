package com.baicai.composetutorial.utils

import android.content.Context
import android.widget.Toast

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */
fun toastText(context: Context, text: CharSequence?, isLong: Boolean = false) {
    if (text.isNullOrBlank()) return
    Toast.makeText(context, text, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}