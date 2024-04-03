package abhishek.pathak.mockwithai.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationViewModel : ViewModel() {

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    private lateinit var firebaseUser: FirebaseUser
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    private val _registerStatus = MutableLiveData<String>()
    val registerStatus: LiveData<String> = _registerStatus

    private val _verifyEmailStatus = MutableLiveData<String>()
    val verifyEmailStatus: LiveData<String> = _verifyEmailStatus

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _loginStatus.value = "Email or password cannot be empty"
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _loginStatus.value = "Success"
                } else {
                    _loginStatus.value = "Login failed: ${task.exception?.message}"
                }
            }
    }

    fun register(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _registerStatus.value = "Email or password cannot be empty"
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _registerStatus.value = "Success"
                    firebaseAuth.currentUser?.let {
                        firebaseUser = it
                        sendVerificationEmailLink()
                    }
                } else {
                    _registerStatus.value = "Register failed: ${task.exception?.message}"
                }
            }
    }


    private fun sendVerificationEmailLink() {
        if (this::firebaseUser.isInitialized) {
            firebaseUser.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _verifyEmailStatus.value = "Verification email sent!"
                } else {
                    _verifyEmailStatus.value = "Verification email failed!"
                }
            }
        }
    }
}