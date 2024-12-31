package dev.maxiscoding.myrecipeapp.ui.components.category

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.maxiscoding.myrecipeapp.Category

@Composable
fun CategoriesList(categories: List<Category>, onCategoryClick: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categories.size) { index -> CategoryCard(categories[index], onCategoryClick) }
    }
}