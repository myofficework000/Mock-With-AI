package abhishek.pathak.mockwithai.view.screens
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThemeSwitch(isDarkTheme: Boolean) {
    val context = LocalContext.current

    // Theme switch state
    var isDarkTheme by remember { mutableStateOf(false) }

    // Theme preference setup
    val themePreferences = remember { ThemePreferences(context) }

    // Initialize theme based on preference
    isDarkTheme = themePreferences.themePreference == ThemePreferences.PREF_THEME_DARK

    // Theme preference updater
    val toggleTheme: (Boolean) -> Unit = { isDark ->
        isDarkTheme = isDark
        themePreferences.themePreference = if (isDark) ThemePreferences.PREF_THEME_DARK else ThemePreferences.PREF_THEME_LIGHT
    }

    Box(
        modifier = Modifier
            .background(if (isDarkTheme) Color.Black else Color.White)
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Theme Switch",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.Green,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Toggle switch for switching between dark and light themes
            Switch(
                checked = isDarkTheme,
                onCheckedChange = toggleTheme,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeScreenPreview() {
    ThemeSwitch(isDarkTheme = true)
}

class ThemePreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "theme_preferences", Context.MODE_PRIVATE
    )

    companion object {
        const val PREF_THEME_DARK = "dark"
        const val PREF_THEME_LIGHT = "light"
        private const val KEY_THEME_PREFERENCE = "theme_preference"
    }

    var themePreference: String
        get() = sharedPreferences.getString(KEY_THEME_PREFERENCE, PREF_THEME_LIGHT) ?: PREF_THEME_LIGHT
        set(value) = sharedPreferences.edit().putString(KEY_THEME_PREFERENCE, value).apply()
}