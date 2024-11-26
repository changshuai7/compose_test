package com.example.compose_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_test.components.ColumnLazy
import com.example.compose_test.components.ColumnListView
import com.example.compose_test.components.ComponentBaseLineToTop
import com.example.compose_test.components.ComponentScaffold
import com.example.compose_test.ui.theme.Compose_testTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_testTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Hello Compose")
                            }
                        )
                    }
                ) { padding ->
                    ComposeBodyContent(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun ComposeBodyContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(1.dp)
            )
            ComponentBaseLineToTop()
        }
    }
}
