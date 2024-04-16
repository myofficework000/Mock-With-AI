package abhishek.pathak.mockwithai.chatbot

import com.google.gson.annotations.SerializedName

data class MessageX(
    @SerializedName("content")val content: String,
    @SerializedName("role")val role: String
)