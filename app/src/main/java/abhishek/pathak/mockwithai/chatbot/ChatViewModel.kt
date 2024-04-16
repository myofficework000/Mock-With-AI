package abhishek.pathak.mockwithai.chatbot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChatViewModel() : ViewModel() {

    private lateinit var openAIAPIService: OpenAIAPIService
    private val compositeDisposable = CompositeDisposable()

    private val _aiResponseLiveData = MutableLiveData<ChatBotResponse>()
    val aiResponseLiveData: LiveData<ChatBotResponse> = _aiResponseLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun fetchAIResponse(userInput: String) {
        openAIAPIService= RetrofitBuilder.getRetrofit().create(OpenAIAPIService::class.java)
        val messages = listOf(MessageX(userInput, "user")) // Assuming user input should be sent as a user message
        val chatBotInput = ChatBotInput(messages, "gpt-3.5-turbo")

        compositeDisposable.add(
            openAIAPIService.getCompletion(chatBotInput)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        handleResponse(response)
                    },
                    { error ->
                        _errorLiveData.value = error.message
                    }
                )
        )
    }

    private fun handleResponse(response: ChatBotResponse) {
        _aiResponseLiveData.value = response
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}