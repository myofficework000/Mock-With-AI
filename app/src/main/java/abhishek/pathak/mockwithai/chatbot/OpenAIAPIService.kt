package abhishek.pathak.mockwithai.chatbot

import abhishek.pathak.mockwithai.chatbot.ConstantChat.END_POINT
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIAPIService {
    @POST(END_POINT)
    fun getCompletion(
        @Body chatBotInput: ChatBotInput
    ): Single<ChatBotResponse>
}