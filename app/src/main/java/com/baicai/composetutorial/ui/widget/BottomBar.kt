package com.baicai.composetutorial.ui.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baicai.composetutorial.R
import com.baicai.composetutorial.ui.theme.QtMain
import com.baicai.composetutorial.ui.theme.QtStrong

/**
 * @author liuyi@qingting.fm
 * @date 2023/07/11
 */

@Composable
fun BottomBar(selected: Int, action: ((position: Int) -> Unit)? = null) {
    Row(
        modifier = Modifier.padding(0.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TabItem(R.drawable.ic_home, "首页", 0, selected, action)
        TabItem(R.drawable.ic_vip, "超级会员", 1, selected, action)
        TabItem(R.drawable.ic_sounds, "声界", 2, selected, action)
        TabItem(R.drawable.ic_listen, "我听", 3, selected, action)
        TabItem(R.drawable.ic_mine, "个人中心", 4, selected, action)
    }
}

@Composable
fun TabItem(
    @DrawableRes resId: Int,
    title: String,
    position: Int = 0,
    selectedTab: Int = 0,
    action: ((position: Int) -> Unit)? = null
) {
    val selected = selectedTab == position
    Button(
        onClick = { action?.invoke(selectedTab) },
        contentPadding = PaddingValues(0.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    ) {
        //        Icon(
//            bitmap = ImageBitmap.imageResource(id = resId),
//            contentDescription = title,
//            tint = Color.Unspecified
//        )
//        Icon(painter = painterResource(id = resId), contentDescription = title)
        Column {
            Icon(
                modifier = Modifier.wrapContentSize().align(alignment = Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = resId),
                contentDescription = title,
                tint = if (selected) Color.Unspecified else QtStrong
            )
            Text(
                modifier = Modifier.wrapContentSize().align(alignment = Alignment.CenterHorizontally),
                text = title,
                color = if (selected) QtMain else QtStrong
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(resId = R.drawable.ic_home, title = "我听我听我听我听我听")
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar(selected = 3)
}