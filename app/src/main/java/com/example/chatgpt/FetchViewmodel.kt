package com.example.chatgpt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FetchViewModel : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data = _data

    @OptIn(DelicateCoroutinesApi::class)
    fun fetchResponse(prompt: String){
        GlobalScope.launch {
            try {
                _data.postValue(openAiResponse().getResponse(prompt))
            }
            catch (e : Exception){
                Log.i("exception", e.message.toString())
            }
        }

    }
}