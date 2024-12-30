package dev.maxiscoding.myrecipeapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorMessage(errorMessage: String) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Error: ${errorMessage}",
        fontSize = 18.sp,
        color = Color.Red
    )
}