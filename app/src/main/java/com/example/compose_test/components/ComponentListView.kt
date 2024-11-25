package com.example.compose_test.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

