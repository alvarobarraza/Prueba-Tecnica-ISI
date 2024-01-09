package com.example.pruebatecnica_isimo.ui.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.pruebatecnica_isimo.R

class BadgeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var badgeCount = 0

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BadgeView)

        val circleColor = attributes.getColor(
            R.styleable.BadgeView_circleColor,
            Color.RED
        )
        circlePaint.color = circleColor

        val textColor = attributes.getColor(
            R.styleable.BadgeView_textColor,
            Color.WHITE
        )
        textPaint.color = textColor

        val textSize = attributes.getDimension(
            R.styleable.BadgeView_textSize,
            resources.getDimensionPixelSize(R.dimen.default_badge_text_size).toFloat()
        )
        textPaint.textSize = textSize

        badgeCount = attributes.getInt(R.styleable.BadgeView_badgeCount, 0)

        attributes.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = centerX.coerceAtMost(centerY)

        canvas.drawCircle(centerX, centerY, radius, circlePaint)

        val text = badgeCount.toString()
        val textWidth = textPaint.measureText(text)
        val textHeight = textPaint.descent() - textPaint.ascent()

        canvas.drawText(
            text,
            centerX - textWidth / 2,
            centerY - textHeight / 2 - textPaint.ascent(),
            textPaint
        )

    }
}