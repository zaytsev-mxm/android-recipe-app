package dev.maxiscoding.myrecipeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import dev.maxiscoding.myrecipeapp.MyRecipeViewModel

@Composable
fun CategoryDetailsScreen(
    viewModel: MyRecipeViewModel,
    categoryId: String,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        val category = viewModel.categoriesState.categories.find { it.idCategory == categoryId }

        Text("Category: ${category?.strCategory ?: "N/A"}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = rememberAsyncImagePainter(category?.strCategoryThumb),
            contentDescription = category?.strCategory,
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(category?.strCategoryDescription ?: "N/A")
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}