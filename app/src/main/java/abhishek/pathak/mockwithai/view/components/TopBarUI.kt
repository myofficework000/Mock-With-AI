package abhishek.pathak.mockwithai.view.components

import abhishek.pathak.mockwithai.navigation.NavigationItem
import abhishek.pathak.mockwithai.ui.theme.White
import abhishek.pathak.mockwithai.ui.theme.dp_0
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_100
import abhishek.pathak.mockwithai.ui.theme.dp_20
import abhishek.pathak.mockwithai.ui.theme.dp_30
import abhishek.pathak.mockwithai.ui.theme.dp_50
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUpAlt
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopBarUI(navController: NavController) {
//    val coroutineScope = rememberCoroutineScope()
//
//    TopAppBar(
//        title = { Text(text = "Tech Interview Pro",
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Medium,
//            modifier = Modifier.padding(dp_20, dp_0))},
//
//
//        navigationIcon = {
//            IconButton(onClick ={coroutineScope.launch { drawerState.open() }}) {
//                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
//            }
//        },
//
//        actions = {
//            IconButton(onClick ={navController.navigate(NavigationItem.USER_ACCOUNT_SCREEN.route)}) {
//                Icon(imageVector = Icons.Default.ThumbUpAlt, contentDescription = null)
//            }
//        },
//
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = White
//        )
//    )
//
//}


@Composable
fun NavigationDrawerUI() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(dp_20, dp_50)
    ) {
        Text(text = "Option 1")
        Text(text = "Option 2")
        Text(text = "Option 3")
        Text(text = "Option 4")
        Text(text = "Option 5")
        Text(text = "Option 6")
    }
}

@Preview
@Composable
private fun TopAppBarPrev() {
//    TopBarUI(rememberNavController())
}