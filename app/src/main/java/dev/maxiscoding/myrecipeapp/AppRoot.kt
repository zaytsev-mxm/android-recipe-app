package dev.maxiscoding.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.maxiscoding.myrecipeapp.ui.screens.CategoriesListScreen
import dev.maxiscoding.myrecipeapp.ui.screens.CategoryDetailsScreen

sealed class Screen(val route: String) {
    data object CategoriesList : Screen("CategoriesList")
    data object CategoryDetails : Screen("CategoryDetails/{categoryId}") {
        fun createRoute(categoryId: String) = "CategoryDetails/$categoryId"
    }
}

@Composable
fun AppRoot(viewModel: MyRecipeViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CategoriesList.route) {
        composable(Screen.CategoriesList.route) {
            CategoriesListScreen(
                isLoading = viewModel.categoriesState.isLoading,
                categories = viewModel.categoriesState.categories,
                errorMessage = viewModel.categoriesState.error
            ) { categoryId ->
                navController.navigate(Screen.CategoryDetails.createRoute(categoryId))
            }
        }

        composable(
            route = Screen.CategoryDetails.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) {
            val categoryId = it.arguments?.getString("categoryId") ?: "999"
            val category = viewModel.categoriesState.categories.find { it.idCategory == categoryId }
            CategoryDetailsScreen(category) { navController.popBackStack() }
        }
    }
}