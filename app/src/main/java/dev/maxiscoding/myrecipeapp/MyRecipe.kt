package dev.maxiscoding.myrecipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyRecipe(viewModel: MyRecipeViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("My Recipe", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(32.dp))
        LazyColumn {
            items(viewModel.categories.categories) { category ->
                Column {
                    Text("Category: ${category.strCategory}", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

}