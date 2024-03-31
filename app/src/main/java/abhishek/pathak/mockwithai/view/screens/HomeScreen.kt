package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.ui.theme.Green40
import abhishek.pathak.mockwithai.ui.theme.Green80
import abhishek.pathak.mockwithai.ui.theme.dp_0
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_12
import abhishek.pathak.mockwithai.ui.theme.dp_16
import abhishek.pathak.mockwithai.ui.theme.dp_6
import abhishek.pathak.mockwithai.ui.theme.dp_8
import abhishek.pathak.mockwithai.ui.theme.sp_14
import abhishek.pathak.mockwithai.ui.theme.sp_18
import abhishek.pathak.mockwithai.ui.theme.sp_40
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HomeScreen() {

    ConstraintLayout(
        modifier = Modifier
            .padding(dp_12, dp_16)
            .fillMaxSize()
    ) {
        
        val (title1, boxes1, title2, lazyColumn) = createRefs()
        val (box1, box2, box3, box4) = createRefs()

        Text(text = "Your Interviews",
            fontSize = sp_18,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(title1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box (
            modifier = Modifier
                .constrainAs(box1) {
                    top.linkTo(title1.bottom)
                    start.linkTo(parent.start)
                }
                .padding(dp_6)
                .fillMaxWidth(0.4f)
        ){
            BoxUIContent(
                title = "Outcomes",
                count = "7",
                unit = "Scores",
                backgroundColor = Green80,
                textColor = Color.White)
        }

        Box (
            modifier = Modifier
                .constrainAs(box2) {
                    top.linkTo(title1.bottom)
                    end.linkTo(parent.end)
                }
                .padding(dp_8,dp_6)
                .fillMaxWidth(0.55f)
        ){
            BoxUIContent(
                title = "History",
                count = "16",
                unit = "Profile",
                backgroundColor = Green40,
                textColor = Color.Black)
        }

        Box (
            modifier = Modifier
                .constrainAs(box3) {
                    top.linkTo(box1.bottom)
                    start.linkTo(parent.start)
                }
                .padding(dp_8,dp_6)
                .fillMaxWidth(0.55f)
        ){
            BoxUIContent(
                title = "Track",
                count = "3",
                unit = "View",
                backgroundColor = Green80,
                textColor = Color.White)
        }

        Box (
            modifier = Modifier
                .constrainAs(box4) {
                    top.linkTo(box1.bottom)
                    end.linkTo(parent.end)
                }
                .padding(dp_6)
                .fillMaxWidth(0.4f)
        ){
            BoxUIContent(
                title = "Outcomes",
                count = "1",
                unit = "Scores",
                backgroundColor = Green80,
                textColor = Color.White)
        }


        Text(text = "Interview Schedule",
            fontSize = sp_18,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(title2){
                top.linkTo(box3.bottom)
                start.linkTo(parent.start)
            }
                .padding(dp_0, dp_10))
    }
}

@Composable
fun BoxUIContent(title: String, count: String, unit: String, backgroundColor: Color, textColor: Color) {
    Column(
        Modifier
            .background(backgroundColor)
            .padding(dp_10, dp_16)) {
        Text(text = title,
            fontSize = sp_14,
            color= textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())

        Text(text = count,
            fontSize = sp_40,
            color= textColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(dp_8))

        Text(text = unit,
            fontSize = sp_14,
            color= textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}

@Preview
@Composable
private fun BoxContentUIPrev() {
    BoxUIContent(
        title = "Outcomes",
        count = "7",
        unit = "Scores",
        backgroundColor = Green80,
        textColor = Color.White)

}