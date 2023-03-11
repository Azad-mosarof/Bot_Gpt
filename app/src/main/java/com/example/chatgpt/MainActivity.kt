package com.example.chatgpt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.chatgpt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val viewmodel = ViewModelProvider(this)[FetchViewModel::class.java]

        binding.send.setOnClickListener{
            binding.idTVResponse.text = ""
            val prompt = binding.idEdtQuery.text.toString()
            binding.idTVQuestion.text = "You : $prompt"
            binding.idEdtQuery.text.clear()
            binding.idTVResponse.text = "BOT : please wait for response....."
            viewmodel.fetchResponse(prompt)
        }

        viewmodel.data.observe(this) { data ->
            // Update the TextView with the new data
            binding.idTVResponse.text = "BOT : $data"
        }
    }
}