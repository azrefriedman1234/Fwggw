package com.pasiflonet.mobile.media

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class OverlayView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

  private val stroke = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.STROKE
    strokeWidth = 6f
  }
  private val fill = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.FILL
    alpha = 50
  }

  private var modeAdd = true
  private val rects = mutableListOf<RectF>()
  private var startX = 0f
  private var startY = 0f
  private var current: RectF? = null

  fun setModeAdd() { modeAdd = true }
  fun clearAll() { rects.clear(); current = null; invalidate() }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    for (r in rects) {
      canvas.drawRect(r, fill)
      canvas.drawRect(r, stroke)
    }
    current?.let {
      canvas.drawRect(it, fill)
      canvas.drawRect(it, stroke)
    }
  }

  override fun onTouchEvent(event: MotionEvent): Boolean {
    if (!modeAdd) return false
    when (event.actionMasked) {
      MotionEvent.ACTION_DOWN -> {
        startX = event.x
        startY = event.y
        current = RectF(startX, startY, startX, startY)
        invalidate()
        return true
      }
      MotionEvent.ACTION_MOVE -> {
        val cx = event.x
        val cy = event.y
        current?.set(minOf(startX, cx), minOf(startY, cy), maxOf(startX, cx), maxOf(startY, cy))
        invalidate()
        return true
      }
      MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
        current?.let {
          if (abs(it.width()) > 10 && abs(it.height()) > 10) rects.add(RectF(it))
        }
        current = null
        invalidate()
        return true
      }
    }
    return super.onTouchEvent(event)
  }
}
