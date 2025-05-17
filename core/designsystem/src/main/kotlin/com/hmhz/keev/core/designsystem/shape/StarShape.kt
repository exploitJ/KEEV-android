package com.hmhz.keev.core.designsystem.shape

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.copy
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection

private fun buildOriginalStarPath(): Path {
    return Path().apply {
        moveTo(25f, 41.289f)
        lineTo(37.134f, 47.652f)
        cubicTo(39.38f, 48.829f, 41.998f, 46.919f, 41.572f, 44.419f)
        lineTo(39.29f, 30.876f)
        lineTo(49.071f, 21.263f)
        cubicTo(50.88f, 19.485f, 49.88f, 16.403f, 47.376f, 16.03f)
        lineTo(33.828f, 14.017f)
        lineTo(27.743f, 1.706f)
        cubicTo(26.617f, -0.571f, 23.382f, -0.571f, 22.256f, 1.706f)
        lineTo(16.165f, 14.011f)
        lineTo(2.617f, 16.024f)
        cubicTo(0.113f, 16.397f, -0.887f, 19.479f, 0.922f, 21.257f)
        lineTo(10.703f, 30.871f)
        lineTo(8.421f, 44.413f)
        cubicTo(8.001f, 46.919f, 10.613f, 48.823f, 12.859f, 47.646f)
        close()
    }
}

class StarRatingShape(
    val sizeDp: DpSize,
    val spacing: Dp,
    val count: Int,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {

        val widthPx = with(density) { sizeDp.width.toPx() }
        val spacingPx = with(density) { spacing.toPx() }

        val scaledPath = buildOriginalStarPath()

        val scale = widthPx / 50f
        val matrix = Matrix().apply {
            scale(x = scale, y = scale)
        }
        scaledPath.transform(matrix)

        var rating = scaledPath.copy()
        val offset = Offset(x = widthPx + spacingPx, y = 0f)
        repeat(count - 1) {
            scaledPath.translate(offset)
            rating = rating.plus(scaledPath)
        }

        return Outline.Generic(rating)
    }
}

