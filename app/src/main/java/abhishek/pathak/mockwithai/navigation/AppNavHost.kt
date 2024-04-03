package abhishek.pathak.mockwithai.navigation

import abhishek.pathak.mockwithai.view.screens.LoginScreenUI
import abhishek.pathak.mockwithai.view.screens.BookMarkScreen
import abhishek.pathak.mockwithai.view.screens.HomeScreen
import abhishek.pathak.mockwithai.view.screens.ScaffoldUI
import abhishek.pathak.mockwithai.view.screens.SearchScreen
import abhishek.pathak.mockwithai.view.screens.StartInterviewScreen
import abhishek.pathak.mockwithai.view.screens.UserAccountScreen
import abhishek.pathak.mockwithai.view.screens.WelcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String = NavigationItem.WELCOME_SCREEN.route
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination)
    {

        composable(NavigationItem.WELCOME_SCREEN.route){ WelcomeScreen(navHostController) }

        composable(NavigationItem.LOGIN_SCREEN.route){ LoginScreenUI(navHostController) }

        composable(NavigationItem.INTERVIEW_SCHEDULE.route){ StartInterviewScreen() }

        composable(NavigationItem.SCAFFOLDUI.route){ ScaffoldUI() }

        composable(NavigationItem.HOME_SCREEN.route){ HomeScreen() }

        composable(NavigationItem.SEARCH_SCREEN.route){ SearchScreen() }

        composable(NavigationItem.BOOK_MARK_SCREEN.route){ BookMarkScreen() }

        composable(NavigationItem.USER_ACCOUNT_SCREEN.route){ UserAccountScreen() }
    }
}