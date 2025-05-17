package com.hmhz.keev.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hmhz.keev.core.designsystem.theme.AppColors

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    gap: Dp = 4.dp,
    size: Dp = 6.dp,
    selectedSize: Dp = 6.dp,
    selectedIndex: Int,
    count: Int,
) {
    Row(
        modifier = modifier,
    ) {
        for (i in 0 until count) {
            val selected = i == selectedIndex
            val sizeToUse = if (selected) selectedSize else size
            val color = if (selected) AppColors.BrandColor500 else AppColors.Gray700

            Box(
                modifier = Modifier.padding(horizontal = gap/2)
                    .size(sizeToUse)
                    .background(shape = CircleShape, color = color),
            )
        }


    }
}

@Preview
@Composable
private fun PageIndicatorPreview() {

    PageIndicator(selectedIndex = 2, count = 5)
}