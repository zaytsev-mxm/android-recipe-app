package dev.maxiscoding.myrecipeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.maxiscoding.myrecipeapp.ui.components.ErrorMessage
import dev.maxiscoding.myrecipeapp.ui.components.Loader
import dev.maxiscoding.myrecipeapp.ui.components.category.CategoriesList

@Composable
fun MyRecipeScreen(viewModel: MyRecipeViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("My Recipe", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(32.dp))
        if (viewModel.categoriesState.isLoading) {
            Loader()
        }
        if (viewModel.categoriesState.categories.isNotEmpty()) {
            CategoriesList(viewModel.categoriesState.categories)
        }
        if (viewModel.categoriesState.error != null) {
            val errorMessage = viewModel.categoriesState.error ?: ""
            ErrorMessage(errorMessage)
        }
    }

}