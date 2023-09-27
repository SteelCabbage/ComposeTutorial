package com.baicai.composetutorial.page

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baicai.composetutorial.ui.theme.QtStronger
import com.baicai.composetutorial.ui.theme.QtWeak
import com.baicai.composetutorial.utils.toastText
import kotlinx.coroutines.delay

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageListen() {
    val pageName = "我听"
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF48CFAD))
    ) {
        Text(text = pageName,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    toastText(context, pageName)
                })

        var textInput by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            value = textInput,
            onValueChange = { str ->
                Log.i("baicai", "TextField onValueChange=$str")
                textInput = str
            },
            placeholder = { Text(text = "请输入你想听的吧～", color = QtWeak) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = QtStronger,
                containerColor = Color(0xFF37BC9B),
                cursorColor = Color(0xFFF6BB42),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
//                disabledIndicatorColor = Color.Transparent,
            )
        )

        Spacer(Modifier.height(20.dp))
        TestRemember0()

        Spacer(Modifier.height(20.dp))
        TestRemember1(textInput)

        Spacer(Modifier.height(20.dp))
        TestRemember2()

        Spacer(Modifier.height(20.dp))
        TestRemember3()
    }
}

@Composable
fun TestRemember0() {
    // 正确使用
    // mutableStateOf 返回 MutableState<T>
    // remember可以带key缓存
    var slogan0 by remember { mutableStateOf("slogan0: Hi~!") }

    Text(slogan0)

    /*
    1. key值可以填多个, 当key的值改变时, 协程这段重新执行
    2. 可以填true, false, Unit(官方), 都表示这段仅执行一次
     */
    LaunchedEffect(Unit) {
        delay(3000)
        slogan0 = "slogan0 Hello Rabbit~!"
    }
}

@Composable
fun TestRemember1(content: String) {
    val first = content.getOrNull(0)
    val contentLength = remember(first) { complexCompute(content) }
    Column {
        Text(content)
        Text("TestRemember1 content length=$contentLength")
    }
}

fun complexCompute(content: String): Int {
    Log.w("baicai", "complexCompute ------> content=$content")
    return content.length
}

@Composable
fun TestRemember2() {
    // 错误使用, slogan2的变化造成重组, 但本身不在重组作用域内(包了一层button), 所以看似正常
    var slogan2 by mutableStateOf("slogan2: Hi~!")

    Log.e("baicai", "TestRemember2 重组")
    // 这边Button如果换成Row, 因为Row是个inline函数, 会造成TestRemember2本身重组;
    // 因为内联函数编译期会在调用处展开, 无法在下次重组时找到合适入口, 只能共享调用方的重组范围
    Button(onClick = {}) {
        Text(slogan2)
    }

    LaunchedEffect(Unit) {
        delay(3000)
        slogan2 = "slogan2 Hello Rabbit~!"
    }
}

@Composable
fun TestRemember3() {
    // 1. 错误使用, 编译器也会报红提示: Creating a state object during composition without using remember
    // 2. slogan3的变化造成重组, 因本身在重组作用域内, 会被再次初始化, 导致ui无变化
    var slogan3 by mutableStateOf("slogan3: Hi~!")

    Text(slogan3)

    LaunchedEffect(Unit) {
        delay(3000)
        slogan3 = "slogan3 Hello Rabbit~!"
    }
}

@Preview(showBackground = true)
@Composable
fun PageListenPreview() {
    PageListen()
}
