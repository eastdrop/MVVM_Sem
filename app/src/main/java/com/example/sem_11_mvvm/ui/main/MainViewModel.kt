package com.example.sem_11_mvvm.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel (private val repository: MainRepository) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Success)
    val state = _state.asStateFlow()
    private  val _error = Channel<String>()
    val error = _error.receiveAsFlow()

    private val _credentials = MutableStateFlow(Credentials())
    val credentials = _credentials.asStateFlow()

    init {
        Log.d(TAG, "init: ")
    }

    fun onButtonClick() {
        Log.d(TAG, "onButtonClick: ")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

    fun onSignInClick() {
        viewModelScope.launch {
            val login: String = credentials.value.login
            val password: String = credentials.value.password
            val isLoginEmpty = login.isBlank()
            val isPasswordEmpty = password.isBlank()
            if (isLoginEmpty || isPasswordEmpty) {
                var loginError: String? = null
                if (isLoginEmpty){
                    loginError = "Required Login"
                }
                var passwordError: String? = null
                if (isPasswordEmpty){
                    passwordError = "Required Password"
                }
                _state.value = State.Error(loginError, passwordError)
                _error.send("Login or Password not valid")
            } else {
                _state.value = State.Loading
                try {
                repository.getData()
                _state.value = State.Success
                } catch (e: Exception){
                    _error.send(e.toString())
                    _state.value = State.Error(null, null)
                }
            }
        }
    }
}