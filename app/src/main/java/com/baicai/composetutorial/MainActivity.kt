package com.baicai.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baicai.composetutorial.page.PageHome
import com.baicai.composetutorial.page.PageListen
import com.baicai.composetutorial.page.PageMine
import com.baicai.composetutorial.page.PageSounds
import com.baicai.composetutorial.page.PageVip
import com.baicai.composetutorial.ui.theme.ComposeTutorialTheme
import com.baicai.composetutorial.ui.widget.BottomBar
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.generateData()
            ComposeTutorialTheme {
                HomePage(viewModel)
            }
            lifecycleScope
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(viewModel: MainViewModel) {
    val pagerState = rememberPagerState()

    // Pager的position监听
    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            // Do something with each page change, for example:
            // viewModel.sendPageSelectedEvent(page)
            viewModel.selectedTab = page
        }
    }

    Column {
        HorizontalPager(
            pageCount = 5,
            state = pagerState,
            modifier = Modifier.weight(1F)
        ) { page ->
            when (page) {
                0 -> PageHome()
                1 -> PageVip()
                2 -> PageSounds()
                3 -> PageListen()
                4 -> PageMine()
            }
        }

        val coroutineScope = rememberCoroutineScope()
        BottomBar(viewModel.selectedTab) {
            viewModel.selectedTab = it
            coroutineScope.launch {
//                pagerState.animateScrollToPage(it)
                pagerState.scrollToPage(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    val viewModel: MainViewModel = viewModel()
    HomePage(viewModel)
}