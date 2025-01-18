package my.android.svgassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import my.android.svgassignment.ui.screen.GenerateScreen
import my.android.svgassignment.ui.screen.HomeScreen
import my.android.svgassignment.ui.screen.RecentlyGeneratedScreen
import my.android.svgassignment.ui.viewmodel.DogViewModel

@Composable
fun AppNavigation(dogViewModel: DogViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen){

        composable<HomeScreen> {
            HomeScreen(
                onNavigateToRecentlyGenerated = {navController.navigate(RecentlyGeneratedScreen)},
                onNavigateToGenerate = {navController.navigate(GenerateScreen)}
            )
        }

        composable<GenerateScreen> {
                GenerateScreen(dogViewModel)
        }

        composable<RecentlyGeneratedScreen> {
            RecentlyGeneratedScreen(dogViewModel)
        }
    }
}