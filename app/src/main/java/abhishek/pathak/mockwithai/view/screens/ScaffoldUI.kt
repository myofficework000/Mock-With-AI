package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.R
import abhishek.pathak.mockwithai.navigation.BottomNaviItems
import abhishek.pathak.mockwithai.ui.theme.White
import abhishek.pathak.mockwithai.ui.theme.dp_0
import abhishek.pathak.mockwithai.ui.theme.dp_20
import abhishek.pathak.mockwithai.view.components.BottomBarUI
import abhishek.pathak.mockwithai.view.components.NavigationDrawerUI
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUpAlt
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldUI() {

    val navController = rememberNavController()

    val coroutineScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)

        ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerUI()
        }) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = stringResource(id = R.string.app_header),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(dp_20, dp_0))
                        },

                        navigationIcon = {
                            IconButton(onClick ={coroutineScope.launch { drawerState.open() }}) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            }
                        },

                        actions = {
                            IconButton(onClick ={navController.navigate(BottomNaviItems.ACCOUNT.route)}) {
                                Icon(imageVector = Icons.Default.ThumbUpAlt, contentDescription = null)
                            }
                        },

                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = White
                        )
                    ) },

                bottomBar = { BottomBarUI(navController = navController) }
            ) {

                NavHost(
                    navController = navController,
                    startDestination = BottomNaviItems.HOME.route,
                    modifier = Modifier.padding(it)
                ) {

                    composable(BottomNaviItems.HOME.route) { HomeScreen() }
                    composable(BottomNaviItems.SEARCH.route) { SearchScreen() }
                    composable(BottomNaviItems.BOOKMARK.route) { BookMarkScreen() }
                    composable(BottomNaviItems.ACCOUNT.route) { UserAccountScreen() }
                }
            }
        }
}

@Preview
@Composable
private fun ScaffoldPrev() {
    ScaffoldUI()
}