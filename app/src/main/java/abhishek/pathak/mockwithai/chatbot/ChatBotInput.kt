package abhishek.pathak.mockwithai.chatbot

import com.google.gson.annotations.SerializedName

data class ChatBotInput(
   @SerializedName("messages") val messages: List<MessageX>,
   @SerializedName("model")val model: String
)