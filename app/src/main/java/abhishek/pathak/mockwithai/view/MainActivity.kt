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
import abhishek.pathak.mockwithai.ui.theme.Pink40
import abhishek.pathak.mockwithai.ui.theme.Pink80
import abhishek.pathak.mockwithai.ui.theme.Purple40
import abhishek.pathak.mockwithai.ui.theme.Purple80
import abhishek.pathak.mockwithai.ui.theme.PurpleGrey40
import abhishek.pathak.mockwithai.ui.theme.PurpleGrey80
import abhishek.pathak.mockwithai.view.screens.ThemePreferences
import abhishek.pathak.mockwithai.view.screens.ThemeSwitch
import androidx.compose.material3.Switch
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var isDarkTheme by remember { mutableStateOf(false) }

            MockWithAITheme(darkTheme = isDarkTheme) {
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
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)
@Composable
fun ThemeScreen() {
    val context = LocalContext.current
    val themePreferences = remember { ThemePreferences(context) }
    var isDarkTheme by remember { mutableStateOf(themePreferences.themePreference == ThemePreferences.PREF_THEME_DARK) }

    MaterialTheme(
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme
    ) {
        ThemeSwitch(isDarkTheme)
    }
}