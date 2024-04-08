package abhishek.pathak.mockwithai.view

import abhishek.pathak.mockwithai.navigation.AppNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import abhishek.pathak.mockwithai.ui.theme.MockWithAITheme
import abhishek.pathak.mockwithai.view.screens.ScaffoldUI
import abhishek.pathak.mockwithai.view.screens.WelcomeScreen
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import abhishek.pathak.mockwithai.ui.theme.MockWithAITheme
import abhishek.pathak.mockwithai.navigation.AppNavHost
import androidx.navigation.compose.rememberNavController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockWithAITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(navHostController = rememberNavController())
                }
            }
        }
    }
}