package abhishek.pathak.mockwithai

import abhishek.pathak.mockwithai.ui.theme.Black
import abhishek.pathak.mockwithai.ui.theme.Green
import abhishek.pathak.mockwithai.ui.theme.White
import abhishek.pathak.mockwithai.ui.theme.dp_16
import abhishek.pathak.mockwithai.ui.theme.dp_180
import abhishek.pathak.mockwithai.ui.theme.dp_20
import abhishek.pathak.mockwithai.ui.theme.dp_24
import abhishek.pathak.mockwithai.ui.theme.dp_40
import abhishek.pathak.mockwithai.ui.theme.dp_50
import abhishek.pathak.mockwithai.ui.theme.dp_8
import abhishek.pathak.mockwithai.ui.theme.sp_30
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.stringResource

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    label: String,
    placeholder: String,
    showPassword: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(dp_24),
        label = { Text(text = label, color = Black) },
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        trailingIcon = {
            IconButton(onClick = { onTogglePasswordVisibility() }) {
                Icon(
                    imageVector = if (showPassword) Icons.Outlined.VisibilityOff
                    else Icons.Outlined.Visibility,
                    contentDescription = if (showPassword)  stringResource(id = R.string.HidePassword) else  stringResource(id = R.string.ShowPasword)
                )
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun LoginScreenUI() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize()
            .padding(top = dp_40)
    ) {
        Image(
            painter = painterResource(id = R.drawable.jobintervie),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dp_180)
                .align(Alignment.TopCenter)
        )
        Card(modifier = Modifier
            .padding(dp_50)
            .align(Alignment.Center), shape = RoundedCornerShape(dp_20)){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Green)
        ) {
            Text(
                text = stringResource(id = R.string.Login),
                textAlign = TextAlign.Center,
                fontSize = sp_30,
                color = White,
                modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(dp_16))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text =  stringResource(id = R.string.Email), color = Black) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(dp_24)
                )
                Spacer(modifier = Modifier.height(dp_16))
                PasswordTextField(
                    value = password,
                    onValueChange = { password = it },
                    label =  stringResource(id = R.string.Password),
                    placeholder =  stringResource(id = R.string.EnterYourPassword),
                    showPassword = showPassword,
                    onTogglePasswordVisibility = { showPassword = !showPassword }
                )
                Spacer(modifier = Modifier.height(dp_8))
                Text(
                    text =  stringResource(id = R.string.ForgotPassword),
                    textAlign = TextAlign.Right,
                    color = White,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(dp_20))
                Button(
                    onClick={},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(White)
                ){
                    Text(text =  stringResource(id = R.string.Login), color = Green)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenUI()
}
