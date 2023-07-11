package com.baicai.composetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baicai.composetutorial.ui.theme.ComposeTutorialTheme
import com.baicai.composetutorial.ui.theme.QtMain
import com.baicai.composetutorial.ui.theme.QtStrong
import androidx.compose.foundation.pager.HorizontalPager

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
//                Greeting("World~")
                HorizontalPager(pageCount = 5) {

                }
                BottomBar(2)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        fontSize = 18.sp,
        textAlign = TextAlign.End,
        modifier = Modifier
            .padding(20.dp)
            .background(color = Color(0xFFFF0000), shape = RoundedCornerShape(5.dp, 10.dp, 0.dp, 5.dp))
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom)
            .padding(8.dp)
    )

    Text(
        text = "$name! Hello～～",
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color(0xFF00FF00), shape = RoundedCornerShape(5.dp, 10.dp, 0.dp, 5.dp))
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom)
            .padding(5.dp)
            .clickable { showToast(context, "hahahaha") }
    )
}

private fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

@Composable
private fun BottomBar(selected: Int) {
    Row {
        TabItem(R.drawable.ic_home, "首页", selected == 0)
        TabItem(R.drawable.ic_vip, "超级会员", selected == 1)
        TabItem(R.drawable.ic_sounds, "声界", selected == 2)
        TabItem(R.drawable.ic_listen, "我听", selected == 3)
        TabItem(R.drawable.ic_mine, "个人中心", selected == 4)
    }
}

@Composable
private fun TabItem(@DrawableRes resId: Int, title: String, selected: Boolean = false) {
    Column {
//        Icon(
//            bitmap = ImageBitmap.imageResource(id = resId),
//            contentDescription = title,
//            tint = Color.Unspecified
//        )
//        Icon(painter = painterResource(id = resId), contentDescription = title)
        Icon(
            imageVector = ImageVector.vectorResource(id = resId),
            contentDescription = title,
            tint = if (selected) Color.Unspecified else QtStrong
        )
        Text(text = title, color = if (selected) QtMain else QtStrong)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(resId = R.drawable.ic_home, title = "我听")
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar(selected = 3)
}

@Preview(showBackground = true)
@Composable
fun ConstraintPreview() {
    Greeting("Android~~~~")
}