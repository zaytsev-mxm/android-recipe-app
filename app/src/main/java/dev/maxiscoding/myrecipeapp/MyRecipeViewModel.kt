package dev.maxiscoding.myrecipeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyRecipeViewModel: ViewModel() {
    private var _categories by mutableStateOf(CategoriesResponse())
    val categories: CategoriesResponse
        get() = _categories

    init {
        viewModelScope.launch {
            _categories = recipeService.getCategories()
        }
    }
}