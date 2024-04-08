package abhishek.pathak.mockwithai.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    var email = mutableStateOf("")
    var password = mutableStateOf("")

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    private val _registerStatus = MutableLiveData<String>()
    val registerStatus: LiveData<String> = _registerStatus

    private val _verifyEmailStatus = MutableLiveData<String>()
    val verifyEmailStatus: LiveData<String> = _verifyEmailStatus

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _loginStatus.postValue("Email or password cannot be empty")
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _loginStatus.postValue("Success")
            } else {
                _loginStatus.postValue("Login failed: ${task.exception?.message}")
            }
        }
    }

    fun register(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _registerStatus.postValue("Email or password cannot be empty")
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _registerStatus.postValue("Success")
                firebaseAuth.currentUser?.sendVerificationEmailLink()
            } else {
                _registerStatus.postValue("Register failed: ${task.exception?.message}")
            }
        }
    }

    private fun FirebaseUser.sendVerificationEmailLink() {
        sendEmailVerification().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _verifyEmailStatus.postValue("Verification email sent!")
            } else {
                _verifyEmailStatus.postValue("Verification email failed!")
            }
        }
    }
}
