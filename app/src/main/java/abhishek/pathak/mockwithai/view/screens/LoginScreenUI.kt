package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.R
import abhishek.pathak.mockwithai.navigation.NavigationItem
import abhishek.pathak.mockwithai.ui.theme.Green
import abhishek.pathak.mockwithai.ui.theme.White
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_16
import abhishek.pathak.mockwithai.ui.theme.dp_180
import abhishek.pathak.mockwithai.ui.theme.dp_20
import abhishek.pathak.mockwithai.ui.theme.dp_40
import abhishek.pathak.mockwithai.ui.theme.sp_30
import abhishek.pathak.mockwithai.viewmodel.AuthenticationViewModel
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginScreenUI(navController: NavController) {
    val authenticationViewModel: AuthenticationViewModel = hiltViewModel()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword: Boolean by remember { mutableStateOf(false) }
    var isLoginScreen: Boolean by remember { mutableStateOf(false) }
    val loginStatus by authenticationViewModel.loginStatus.observeAsState()
    val registerStatus by authenticationViewModel.registerStatus.observeAsState()
    val verifyEmailStatus by authenticationViewModel.verifyEmailStatus.observeAsState()

    verifyEmailStatus?.let { status ->
        showToast(context, status)
    }

    loginStatus?.let { status ->
        if (status == "Success") {
            showToast(context, status)

            // Navigate to ScaffoldUI upon successful login
            //navController.navigate(NavigationItem.SCAFFOLDUI.route)
        } else {
            showToast(context, status)
            Log.i("error", "error")
        }
    }

    registerStatus?.let { status ->
        if (status == "Success") {
            showToast(context, status)
            //Navigate to ScaffoldUI upon successful registration
            navController.navigate(NavigationItem.SCAFFOLDUI.route)
        } else {
            showToast(context, status)
        }
    }

    Box(
        modifier = Modifier
            .background(color = Green)
            .fillMaxSize()
            .padding(top = dp_40)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Green)
        ) {
            Image(
                painter = painterResource(id = R.drawable.jobintervie),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dp_180)
            )

            Text(
                text = if (isLoginScreen) stringResource(id = R.string.Login) else stringResource(id = R.string.Register),
                textAlign = TextAlign.Center,
                fontSize = sp_30,
                color = White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(dp_16))

            // Email field
            TextField(
                modifier = Modifier
                    .fillMaxWidth().padding(top=dp_10,start = dp_20, end = dp_20),
                value = email,
                onValueChange = {
                    email = it
                    println("Email: $it") // Logging email value
                },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            TextField(
                modifier = Modifier
                    .fillMaxWidth().padding(dp_20),
                value = password,
                onValueChange = {
                    password = it
                    println("Password: $it") // Logging password value
                },
                label = { Text("Password") },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login/Register Button
            Button(
                onClick = {
                    val currentEmail = email
                    val currentPassword = password
                    if (isLoginScreen) {
                        authenticationViewModel.login(currentEmail, currentPassword)
                    } else {
                        authenticationViewModel.register(currentEmail, currentPassword)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth().padding(dp_10),
            ) {
                Text(if (isLoginScreen) "Login" else "Register")
            }

            // Toggle switch for switching between login and register screens
            Spacer(modifier = Modifier.height(16.dp))
            Switch(
                checked = isLoginScreen,
                onCheckedChange = { isLoginScreen = it },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(text = "Skip login", modifier = Modifier.clickable {
                navController.navigate(NavigationItem.SCAFFOLDUI.route)
            })
        }
    }
}



fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenUI(rememberNavController())
}
