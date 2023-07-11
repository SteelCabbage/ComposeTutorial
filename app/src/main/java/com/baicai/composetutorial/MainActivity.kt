package com.baicai.composetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baicai.composetutorial.ui.theme.ComposeTutorialTheme
import com.baicai.composetutorial.ui.widget.BottomBar
import com.baicai.composetutorial.ui.widget.HelloWorld

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
//                Greeting("World~")
                HomePage(viewModel)
//                HelloWorld("哈哈哈")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(viewModel: MainViewModel) {
    Column {
//        HorizontalPager(pageCount = 5) { page ->
//            when (page) {
//                0 -> Box { Modifier.fillMaxSize().background(color = Color(0xFFFFFFFF)) }
//                1 -> Box { Modifier.fillMaxSize().background(color = Color(0xFF00FF00)) }
//                2 -> Box { Modifier.fillMaxSize().background(color = Color(0xFF0000FF)) }
//                3 -> Box { Modifier.fillMaxSize().background(color = Color(0xFFFF00FF)) }
//                4 -> Box { Modifier.fillMaxSize().background(color = Color(0xFFFFFF00)) }
//            }
//        }
        BottomBar(viewModel.selectedTab) {
            viewModel.selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
//    HomePage()
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

@Preview(showBackground = true)
@Composable
fun ConstraintPreview() {
    Greeting("Android~~~~")
}