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
            CategoriesListScreen(viewModel) { categoryId ->
                navController.navigate(Screen.CategoryDetails.createRoute(categoryId))
            }
        }

        composable(
            route = Screen.CategoryDetails.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) {
            val categoryId = it.arguments?.getString("categoryId") ?: "999"
            CategoryDetailsScreen(
                viewModel = viewModel,
                categoryId = categoryId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}