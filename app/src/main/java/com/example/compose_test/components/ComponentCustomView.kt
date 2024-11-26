package com.example.compose_test.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.firstBaseLineToTop(
    firstBaseLineToTop: Dp
): Modifier {
    return this.then(
        other = Modifier.layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            val baseLine = placeable[FirstBaseline]
            val diff = firstBaseLineToTop.roundToPx() - baseLine
            layout(placeable.width, placeable.height + diff) {
                placeable.placeRelative(0, diff)
            }
        }
    )
}


@Preview
@Composable
fun ComponentBaseLineToTop() {
    Text(
        text = "Hello World",
        modifier = Modifier
            .background(Color.Red)
            .firstBaseLineToTop(50.dp)
    )
}