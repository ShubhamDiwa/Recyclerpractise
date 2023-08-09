package com.vasyerp.testingtemp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vasyerp.testingtemp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() ,sendata{
    private val binding:ActivityMain2Binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }


    }

    override fun name(name: String) {
        var name=binding.etSendname.text.toString()

    }



}