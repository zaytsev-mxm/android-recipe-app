package dev.maxiscoding.myrecipeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.maxiscoding.myrecipeapp.Category
import dev.maxiscoding.myrecipeapp.ui.components.ErrorMessage
import dev.maxiscoding.myrecipeapp.ui.components.Loader
import dev.maxiscoding.myrecipeapp.ui.components.category.CategoriesList

@Composable
fun CategoriesListScreen(
    isLoading: Boolean = false,
    categories: List<Category> = listOf(),
    errorMessage: String?,
    onCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("My Recipe", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(32.dp))
        if (isLoading) {
            Loader()
        }
        if (categories.isNotEmpty()) {
            CategoriesList(categories) { categoryId ->
                onCategoryClick(
                    categoryId
                )
            }
        }
        if (errorMessage != null) {
            ErrorMessage(errorMessage)
        }
    }
}