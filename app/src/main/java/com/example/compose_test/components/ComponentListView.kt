package com.example.compose_test.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch

@Composable
fun ColumnNoScroll() {

    /**
     * 不可滚动列表
     */
    Column {
        repeat(100) { index ->
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "$index",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
    Text("abc")
}

@Composable
fun ColumnCanScroll() {
    /**
     * 可滚动列表
     */
    val state = rememberScrollState(0)
    Column(
        modifier = Modifier
            .verticalScroll(state)
            .width(100.dp)
            .background(color = Color.Red)
            .padding(10.dp)
    ) {
        repeat(100, action = { index ->
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "$index",
                style = MaterialTheme.typography.titleMedium
            )
        })
    }
}

@Composable
fun ColumnLazy() {
    /**
     * 懒加载的高性能列表
     */
    LazyColumn {
        items(100) { index ->
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "$index",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


@Preview
@Composable
fun ColumnListView() {
    val itemSize = 100
    val scrollState = rememberLazyListState(0)
    val scope = rememberCoroutineScope()
    Column {
        Row {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    scope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }
            ) { Text(text = "滚动到顶部") }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    scope.launch {
                        scrollState.animateScrollToItem(itemSize - 1)
                    }
                }
            ) { Text(text = "滚动到底部") }
        }
        LazyColumn(state = scrollState) {
            items(itemSize) { index ->
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    ColumnListItem(index)
                }
            }
        }
    }
}

@Preview
@Composable
fun ColumnListItem(index: Int = 0) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(40.dp)) {
        Image(
            imageVector = Icons.Filled.Favorite,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text("第 $index 个item")
    }
}

