package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.ui.theme.Green40
import abhishek.pathak.mockwithai.ui.theme.Green60
import abhishek.pathak.mockwithai.ui.theme.Green80
import abhishek.pathak.mockwithai.ui.theme.dp_0
import abhishek.pathak.mockwithai.ui.theme.dp_2
import abhishek.pathak.mockwithai.ui.theme.dp_6
import abhishek.pathak.mockwithai.ui.theme.dp_8
import abhishek.pathak.mockwithai.ui.theme.dp_10
import abhishek.pathak.mockwithai.ui.theme.dp_12
import abhishek.pathak.mockwithai.ui.theme.dp_16
import abhishek.pathak.mockwithai.ui.theme.dp_18
import abhishek.pathak.mockwithai.ui.theme.dp_28
import abhishek.pathak.mockwithai.ui.theme.dp_30
import abhishek.pathak.mockwithai.ui.theme.sp_14
import abhishek.pathak.mockwithai.ui.theme.sp_24
import abhishek.pathak.mockwithai.ui.theme.sp_40
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        
        val (title1, title2) = createRefs()
        val (box1, box2, box3, box4) = createRefs()
        val (interviewBox1, interviewBox2) = createRefs()

        Text(text = "Your Interviews",
            fontSize = sp_24,
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
            SmallBoxUIContent(
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
                .padding(dp_8, dp_6)
                .fillMaxWidth(0.55f)
        ){
            SmallBoxUIContent(
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
                .padding(dp_8, dp_6)
                .fillMaxWidth(0.55f)
        ){
            SmallBoxUIContent(
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
            SmallBoxUIContent(
                title = "Outcomes",
                count = "1",
                unit = "Scores",
                backgroundColor = Green80,
                textColor = Color.White)
        }


        Text(text = "Interview Schedule",
            fontSize = sp_24,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .constrainAs(title2) {
                    top.linkTo(box3.bottom)
                    start.linkTo(parent.start)
                }
                .padding(dp_0, dp_30, dp_0, dp_0))

        Box(
            modifier = Modifier
                .constrainAs(interviewBox1) {
                    top.linkTo(title2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(dp_0, dp_18)
                .clickable { }
        ) {
            LargeBoxUIContent(
                title = "Anwsers",
                task = "Coding Challenge",
                unit = "Questions",
                isOnline = false,
                silent = true
            )
        }

        Box(
            modifier = Modifier
                .constrainAs(interviewBox2) {
                    top.linkTo(interviewBox1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(dp_0, dp_18)
                .clickable { }
        ) {
            LargeBoxUIContent(
                title = "Evaluations",
                task = "Technical Skills",
                unit = "Assess",
                isOnline = true,
                silent = false
            )
        }
    }
}

@Composable
fun SmallBoxUIContent(title: String, count: String, unit: String, backgroundColor: Color, textColor: Color) {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp_8))

        Text(text = unit,
            fontSize = sp_14,
            color= textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun LargeBoxUIContent(title: String, task: String, unit: String, isOnline: Boolean, silent: Boolean) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isOnline) {
                    (Green60)
                } else {
                    Green40
                }
            )
    ) {

        val (txTitle, txTask, txUnit, iconIsOnline, btnSilent) = createRefs()

        var isSilent by remember { mutableStateOf(silent) }
        val icon = if (silent) Icons.Default.NotificationsOff else Icons.Default.Notifications
        val iconDescription = if (silent) "Mute" else "unmute"

        Text(text = title,
            fontSize = sp_14,
            modifier = Modifier
                .constrainAs(txTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(dp_18))

        if (isOnline){
            Box(modifier = Modifier
                .constrainAs(iconIsOnline) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(dp_28, dp_18)
                .background(Green80) ) {
                Text(text = "Online",
                    color = Color.White,
                    fontSize = sp_14,
                    modifier = Modifier.padding(dp_30, dp_2)
                    )}
        }

        Text(text = task,
            fontSize = sp_24,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(txTask) {
                    top.linkTo(txTitle.bottom)
                    start.linkTo(parent.start)
                }
                .padding(dp_18, dp_0))

        Text(text = unit,
            fontSize = sp_14,
            modifier = Modifier
                .constrainAs(txUnit) {
                    top.linkTo(txTask.bottom)
                    start.linkTo(parent.start)
                }
                .padding(dp_18))


        // TODO: Icon click is not working, need help
        IconButton(
            onClick = { isSilent = !isSilent},
            modifier = Modifier.constrainAs(btnSilent){
            top.linkTo(txTask.bottom)
            end.linkTo(parent.end)
        }){
            Icon(
                imageVector = icon,
                contentDescription = iconDescription)
        }
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
    SmallBoxUIContent(
        title = "Outcomes",
        count = "7",
        unit = "Scores",
        backgroundColor = Green80,
        textColor = Color.White)
}

@Preview
@Composable
private fun LargeBoxUIContentPrev() {
    LargeBoxUIContent(
        title = "Anwsers",
        task = "Coding Challenge",
        unit = "Questions",
        isOnline = true,
        silent = false
    )
}