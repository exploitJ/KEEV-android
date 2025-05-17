package com.hmhz.keev.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.ui.util.fastRoundToInt
import com.hmhz.keev.core.designsystem.shape.StarRatingShape
import com.hmhz.keev.core.designsystem.theme.AppColors
import com.hmhz.keev.core.designsystem.theme.KEEVTheme
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    startRating: Float = 0f,
    maxRating: Int = 5,
    itemSize: DpSize,
    itemSpacing: Dp = 4.dp,
    edgePadding: Dp = 4.dp,
    activeColor: Color = AppColors.BrandColor500,
    inactiveColor: Color = AppColors.Gray700,
    onRatingChanged: (Float) -> Unit = {},
) {
    var rating by rememberSaveable {
        mutableFloatStateOf(
            startRating.coerceIn(
                0f,
                maxRating.toFloat(),
            ),
        )
    }
    var barPosition by remember { mutableFloatStateOf(0f) }
    val totalWidth = remember { (itemSize.width * maxRating) + (itemSpacing * (maxRating - 1)) }
    val totalWidthPx = with(LocalDensity.current) { totalWidth.toPx() }

    val clip = remember(arrayOf(edgePadding, itemSize, itemSpacing, maxRating)) {
        StarRatingShape(
            sizeDp = itemSize,
            spacing = itemSpacing,
            count = maxRating,
        )
    }
    val ratingWidth = remember(rating) {
        val fullItems = floor(rating)
        val remainder = rating - fullItems
        val gaps = ((fullItems + ceil(remainder) - 1) * itemSpacing).coerceAtLeast(Dp.Hairline)
        gaps + rating * itemSize.width
    }

    val haptics = LocalHapticFeedback.current

    Box(
        modifier = modifier
            .padding(horizontal = edgePadding)
            .width(totalWidth)
            .height(itemSize.height)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        val newRating = it.x / totalWidthPx * maxRating
                        val snappedRating = (newRating * 2).roundToInt() / 2f
                        barPosition = it.x
                        if (snappedRating != rating) {
                            rating = snappedRating
                            onRatingChanged(rating)
                            haptics.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        }
                    },
                )
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragStart = { offset ->
                        barPosition = offset.x
                    },
                    onDragEnd = {
                        onRatingChanged(rating)
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                    },
                    onDragCancel = {},
                    onHorizontalDrag = { _, dragAmount ->
                        val newPosition = (barPosition + dragAmount)
                        val newRating = newPosition / totalWidthPx * maxRating
                        val snappedRating =
                            ((newRating * 2).fastRoundToInt() / 2f).coerceIn(
                                0f,
                                maxRating.toFloat(),
                            )

                        if (snappedRating != rating) {
                            rating = snappedRating
                            haptics.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        }

                        barPosition = newPosition
                    },
                )
            },
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(clip)
                .background(inactiveColor),
        ) {
            Box(
                Modifier
                    .width(ratingWidth)
                    .fillMaxHeight()
                    .align(Alignment.CenterStart)
                    .background(color = activeColor),
            )
        }
    }
}


@Composable
@Preview
fun RatingBarDemo() {
    var currentRating by remember { mutableFloatStateOf(2.5f) }

    KEEVTheme {

        Column(modifier = Modifier.padding(0.dp)) {
            RatingBar(
                edgePadding = 20.dp,
                startRating = currentRating,
                itemSize = DpSize(50.dp, 48.dp),
                itemSpacing = 20.dp,
                onRatingChanged = { newRating ->
                    currentRating = newRating
                },
            )

            Text(
                text = "Current Rating: $currentRating",
            )
        }
    }
}