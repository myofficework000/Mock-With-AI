package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.view.ThemeScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        ThemeScreen()
    }
}