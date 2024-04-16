package abhishek.pathak.mockwithai.view.screens

import abhishek.pathak.mockwithai.R
import abhishek.pathak.mockwithai.chatbot.ChatViewModel
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OpenAiChatScreen(viewModel: ChatViewModel) {
    val userInputState = remember { mutableStateOf("") }
    val aiResponse by viewModel.aiResponseLiveData.observeAsState()
    val error by viewModel.errorLiveData.observeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.White)) {

            // Display AI output
            TextField(
                value = aiResponse?.toString() ?: "",
                onValueChange = {},
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            // Display error if there's any
            error?.let { errorMessage ->
                Text(text = "Error: $errorMessage")
            }

            // User input field
            Row(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    value = userInputState.value,
                    onValueChange = { userInputState.value = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                )
                IconButton(
                    onClick = {
                        viewModel.fetchAIResponse(userInputState.value)
                        userInputState.value = "" // Clear input field
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_send_24),
                        contentDescription = "Send",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatScreenPrev() {
    val viewModel = remember { ChatViewModel() }
    OpenAiChatScreen(viewModel)
}