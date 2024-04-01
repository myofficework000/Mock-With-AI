package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun UserAccountScreen() {
    ScaffoldUI { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize()) {
                ProfileHeader()
                MenuBar()
                ImageGallery()
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dp_16)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "User Name",
            fontWeight = FontWeight.Bold,
            fontSize = sp_18,
            modifier = Modifier.padding(top = dp_8, bottom = dp_2)
        )
        Text(
            text = "Introduction of User",
            fontSize = sp_14,
            color = Color.Gray
        )
    }
}

@Composable
fun MenuBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dp_16),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MenuBarItem(title = "Score", count = "85")
        MenuBarItem(title = "Outcome", count = "Pa")
        MenuBarItem(title = "Interviews", count = "24")
    }
}

@Composable
fun MenuBarItem(title: String, count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontSize = sp_24, fontWeight = FontWeight.Bold)
        Text(text = title, fontSize = sp_14)
    }
}

@Composable
fun ImageGallery() {
    val imageList = listOf(
        painterResource(R.drawable.image1),
        painterResource(R.drawable.image2),
        painterResource(R.drawable.image3)
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(dp_8)
    ) {
        items(imageList) { painter ->
            ImageItem(painter)
        }
    }
}

@Composable
fun ImageItem(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = "User Image",
        modifier = Modifier
            .size(100.dp)
            .padding(dp_4),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun UserAccountScreenPrev() {
    UserAccountScreen()
}
