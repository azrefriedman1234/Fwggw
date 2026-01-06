package com.pasiflonet.mobile.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pasiflonet.mobile.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
  private lateinit var b: ActivityChatBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    b = ActivityChatBinding.inflate(layoutInflater)
    setContentView(b.root)

    b.btnOpenDetails.setOnClickListener {
      startActivity(Intent(this, DetailsActivity::class.java))
    }
  }
}
