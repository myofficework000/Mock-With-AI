package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.R
import abhishek.pathak.mockwithai.ui.theme.White
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_100
import abhishek.pathak.mockwithai.ui.theme.dp_130
import abhishek.pathak.mockwithai.ui.theme.dp_30
import abhishek.pathak.mockwithai.ui.theme.dp_70
import abhishek.pathak.mockwithai.ui.theme.dp_80
import abhishek.pathak.mockwithai.ui.theme.sp_20
import abhishek.pathak.mockwithai.ui.theme.sp_25
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun StartInterviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
        ) {
            IconButton(
                onClick = {},
                Modifier.paint(painterResource(id = R.drawable.baseline_arrow_back_24))
            ) { }

            Text(
                text = stringResource(id = R.string.start_interview),
                fontWeight = FontWeight.Bold,
                fontSize = sp_25,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dp_10),
                textAlign = TextAlign.Center
            )

        }

            Row(modifier= Modifier
                .fillMaxWidth()
                .height(dp_100).align(Alignment.Start)) {
                Image(painter = painterResource
                    (id = R.drawable.interview)
                    , contentDescription =null,
                    modifier = Modifier
                        .size(dp_80)
                        .padding(dp_10))
                Text(
                    text = stringResource(id = R.string.schedule),
                    fontWeight = FontWeight.Bold,
                    fontSize = sp_20,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dp_30)
                )
            }
        Box(modifier = Modifier
            .padding(dp_10)
            .fillMaxWidth()
            .height(dp_130)
            .background(Color.LightGray)) {
            Row {
                Image(painter = painterResource(id = R.drawable.baseline_calendar_today_24),
                    contentDescription =null,
                    modifier=Modifier.padding(dp_10))
                Text(text = stringResource(id = R.string.choose_duration),
                    fontSize = sp_20,
                    fontWeight = FontWeight.Bold,
                    modifier =  Modifier.padding(dp_10))
            }
            Row(modifier = Modifier.padding(top= dp_70)){
                OutlinedButton(onClick = {}, modifier = Modifier
                    .wrapContentWidth().padding(start= dp_10),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RectangleShape
                ) {
                    Text(text = stringResource(id = R.string.min_30),
                        color = Color.Black)
                }
                OutlinedButton(onClick = {  }, modifier = Modifier
                    .wrapContentWidth().padding(start= dp_10),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RectangleShape
                ) {
                    Text(text = stringResource(id = R.string.min_45),
                        color = Color.Black)
                }
                OutlinedButton(onClick = { }, modifier = Modifier
                    .wrapContentWidth().padding(start= dp_10),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RectangleShape
                ) {
                    Text(text = stringResource(id = R.string.min_60),
                        color = Color.Black)
                }
            }
        }
        }
    }



@Preview
@Composable
fun StartInterviewScreenPrev()
{
    StartInterviewScreen()
}

