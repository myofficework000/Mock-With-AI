package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.R
import abhishek.pathak.mockwithai.navigation.NavigationItem
import abhishek.pathak.mockwithai.ui.theme.Green80
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_100
import abhishek.pathak.mockwithai.ui.theme.dp_130
import abhishek.pathak.mockwithai.ui.theme.dp_20
import abhishek.pathak.mockwithai.ui.theme.dp_300
import abhishek.pathak.mockwithai.ui.theme.dp_350
import abhishek.pathak.mockwithai.ui.theme.dp_40
import abhishek.pathak.mockwithai.ui.theme.sp_20
import abhishek.pathak.mockwithai.ui.theme.sp_25
import abhishek.pathak.mockwithai.ui.theme.sp_30
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun WelcomeScreen(navController: NavController){
Card(
    modifier = Modifier
        .padding(dp_10)
        .fillMaxSize(),
    shape = RoundedCornerShape(dp_40),
    elevation = CardDefaults.cardElevation(),
    colors= CardDefaults.cardColors(Color.White)
){
    Box(modifier = Modifier
        .padding(dp_20)
        .background(Color.LightGray)
        .height(dp_300)
        .fillMaxWidth()) {
        Text(text = stringResource(id = R.string.efficient_approach),
            color = Color.Black,
            fontSize = sp_20,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(dp_130)
                .padding(dp_10))
        Image(painter = painterResource(id = R.drawable._024px_man_working_at_his_desk_cartoon_vector_svg),
            contentDescription = null,
            modifier = Modifier.padding(top=60.dp))
    }
    Text(text = stringResource(id = R.string.interview_success),
        color = Color.Black,
        fontSize = sp_30,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dp_10))
    Text(text = stringResource(id = R.string.Welcome_description),
        color = Color.Black,
        fontSize = sp_20,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dp_10))
    Button(onClick = {navController.navigate(NavigationItem.LOGIN_SCREEN.route) }, modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = dp_100, start = dp_10, end = dp_10)
        .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Green80),
        shape = RectangleShape
    ) {
        Text(text = stringResource(id = R.string.start_now),
            color= Color.Black)
    }
    OutlinedButton(onClick = {navController.navigate(NavigationItem.LOGIN_SCREEN.route) }, modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(dp_10)
        .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RectangleShape
    ) {
        Text(text = stringResource(id = R.string.already_member),
            color = Color.Black)
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPrev(){
    WelcomeScreen(rememberNavController())
}