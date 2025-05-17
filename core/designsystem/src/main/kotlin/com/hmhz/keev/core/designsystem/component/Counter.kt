package com.hmhz.keev.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hmhz.keev.core.designsystem.theme.AppColors
import com.hmhz.keev.core.designsystem.theme.AppTextStyle

@Immutable
data class DayCounterProperties(
    val text: String,
    val modifier: Modifier,
    val textStyle: TextStyle,
    val textColor: Color,
)

fun dayCounterProperties(day: Int): DayCounterProperties = when (day) {

    0 -> DayCounterProperties(
        "D-DAY",
        Modifier
            .background(shape = RoundedCornerShape(4.dp), color = AppColors.BrandColor500a20)
            .padding(horizontal = 6.dp, vertical = 2.dp),
        textStyle = AppTextStyle.Body2XSmallSemiBold,
        textColor = AppColors.BrandColor500,
    )

    in Int.MIN_VALUE..<0 -> DayCounterProperties(
        "D-${-day}",
        Modifier
            .background(shape = RoundedCornerShape(4.dp), color = AppColors.Gray700Bg)
            .padding(horizontal = 6.dp, vertical = 2.dp),
        textStyle = AppTextStyle.Body2XSmallSemiBold,
        textColor = AppColors.Gray400Bg,
    )

    in 1..Int.MAX_VALUE -> DayCounterProperties(
        "D+$day",
        Modifier
            .background(shape = RoundedCornerShape(4.dp), color = Color.Transparent)
            .border(width = 1.5.dp, color = AppColors.Gray700Bg, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp),
        textStyle = AppTextStyle.Body2XSmallSemiBold,
        textColor = AppColors.Gray500Bg,
    )

    else -> DayCounterProperties("Error", Modifier, AppTextStyle.Body2XSmallSemiBold, Color.Red)
}

@Composable
fun DayCounter(day: Int) {
    val props by remember { derivedStateOf { dayCounterProperties(day) } }

    Text(
        text = props.text,
        modifier = props.modifier,
        style = props.textStyle,
        color = props.textColor,
        maxLines = 1,
        overflow = TextOverflow.Clip,
    )
}

@Preview(apiLevel = 35)
@Composable
private fun DayCounterPreview() {
    Column {
        DayCounter(day = 0)
        DayCounter(day = -1)
        DayCounter(day = 11)

    }

}