package com.baicai.composetutorial.page

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baicai.composetutorial.MainViewModel
import com.baicai.composetutorial.TAG
import com.baicai.composetutorial.utils.toastText

/**
 * @author liuyi@qingting.fm
 * @date 2023/7/11
 */

@Composable
fun PageHome() {
    val pageName = "首页"
    val context = LocalContext.current
    val viewModel: MainViewModel = viewModel()
    val dialogVisible = remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFC6E51))
    ) {
        // 测试Text()
        TestText(pageName, context)

        // 点击添加dialog
        TestAddDialog(dialogVisible)

        // 测试稳定性相关
        TestStable(viewModel)

        // 测试项键
        TestListKey()

        // add Dialog
        AddDialog(dialogVisible)
    }
}

@Composable
fun TestAddDialog(dialogVisible: MutableState<Boolean>) {
    Button(onClick = {
        dialogVisible.value = true
    }) {
        Text(text = "点击弹dialog")
    }
}

@Composable
fun AddDialog(dialogVisible: MutableState<Boolean>) {
    val context = LocalContext.current
    if (dialogVisible.value) {
        Dialog(onDismissRequest = {
            dialogVisible.value = false
            toastText(context, "弹窗关闭了")
        }, content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(280.dp)
                    .height(100.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                Text("弹窗测试")
            }
        })
    }
}

@Composable
fun TestStable(viewModel: MainViewModel) {
    Log.w(TAG, "Recompose 范围测试1")
    Column(
        Modifier
            .fillMaxWidth()
            .height(100.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.w(TAG, "Recompose 范围测试2")
        var age by remember { mutableStateOf("10") }

        Text(age, Modifier.clickable {
            age = "100"
            viewModel.user = User("Hi~")
        })

        Complex(viewModel.user)
    }
}

@Composable
fun Complex(user: User) {
    Log.w(TAG, "Recompose Complex()")
    Text(user.name)
}

@Stable
data class User(var name: String) {

}

@Composable
fun TestListKey() {
    val names = remember { mutableStateListOf("0", "1", "2") }
    var id by remember { mutableStateOf(2) }
    Button(onClick = { names.add(0, (++id).toString()) }) {
        Text("点击添加序号")
    }
    LazyColumn(Modifier.fillMaxWidth()) {
        items(names, key = { it }) { name ->
            Item(name)
        }
    }
}

@Composable
fun Item(name: String) {
    Log.d(TAG, "name=$name")
    Text(name)
}

@Composable
fun TestText(pageName: String, context: Context) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = pageName,
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(10.dp)
                .background(
                    color = Color(0xFFED5565),
                    shape = RoundedCornerShape(35.dp, 70.dp, 35.dp, 0.dp)
                )
                .padding(10.dp)
                .padding(10.dp)
                .padding(10.dp)
                .padding(10.dp)
                .padding(10.dp)
                .fillMaxWidth()
                .clickable {
                    toastText(context, pageName)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageHomePreview() {
    PageHome()
}
