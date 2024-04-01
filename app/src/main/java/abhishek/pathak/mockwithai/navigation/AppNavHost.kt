package abhishek.pathak.mockwithai.navigation

import abhishek.pathak.mockwithai.view.screens.BookMarkScreen
import abhishek.pathak.mockwithai.view.screens.HomeScreen
import abhishek.pathak.mockwithai.view.screens.SearchScreen
import abhishek.pathak.mockwithai.view.screens.UserAccountScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String = NavigationItem.HOME_SCREEN.route
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination)
    {
        composable(NavigationItem.HOME_SCREEN.route){ HomeScreen() }

        composable(NavigationItem.SEARCH_SCREEN.route){ SearchScreen() }

        composable(NavigationItem.BOOK_MARK_SCREEN.route){ BookMarkScreen() }

        composable(NavigationItem.USER_ACCOUNT_SCREEN.route){ UserAccountScreen() }
    }
}