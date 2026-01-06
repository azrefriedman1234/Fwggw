package com.pasiflonet.mobile.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pasiflonet.mobile.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
  private lateinit var b: ActivityDetailsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    b = ActivityDetailsBinding.inflate(layoutInflater)
    setContentView(b.root)

    b.btnAddBlur.setOnClickListener { b.overlay.setModeAdd() }
    b.btnClear.setOnClickListener { b.overlay.clearAll() }
  }
}
