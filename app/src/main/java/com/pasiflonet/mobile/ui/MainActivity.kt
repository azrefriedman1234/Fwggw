package com.pasiflonet.mobile.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pasiflonet.mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var b: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    b = ActivityMainBinding.inflate(layoutInflater)
    setContentView(b.root)

    b.btnOpenChat.setOnClickListener {
      startActivity(Intent(this, ChatActivity::class.java))
    }
    b.btnSettings.setOnClickListener {
      startActivity(Intent(this, SettingsActivity::class.java))
    }
  }
}
