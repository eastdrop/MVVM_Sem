package com.example.sem_11_mvvm.ui.main

import kotlinx.coroutines.delay

class MainRepository {
    suspend fun getData(): String{
        delay(5_000)
        return "Done"
    }
}