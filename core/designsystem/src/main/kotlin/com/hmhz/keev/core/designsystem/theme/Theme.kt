package com.hmhz.keev.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import com.hmhz.keev.core.designsystem.theme.AppColors.BrandColor50
import com.hmhz.keev.core.designsystem.theme.AppColors.BrandColor500
import com.hmhz.keev.core.designsystem.theme.AppColors.BrandColor500a20
import com.hmhz.keev.core.designsystem.theme.AppColors.BrandColor500a50
import com.hmhz.keev.core.designsystem.theme.AppColors.Gray300
import com.hmhz.keev.core.designsystem.theme.AppColors.Gray50
import com.hmhz.keev.core.designsystem.theme.AppColors.Gray700
import com.hmhz.keev.core.designsystem.theme.AppColors.Gray800
import com.hmhz.keev.core.designsystem.theme.AppColors.Gray900

private val DarkColorScheme = darkColorScheme(
    primary = BrandColor500,
    onPrimary = Gray50,
    primaryContainer = BrandColor500a20,
    onPrimaryContainer = BrandColor50,
    secondary = BrandColor500a50,
    onSecondary = Gray50,
    secondaryContainer = BrandColor500a20,
    onSecondaryContainer = BrandColor50,
    tertiary = BrandColor500a50,
    onTertiary = Gray50,
    tertiaryContainer = BrandColor500a20,
    onTertiaryContainer = BrandColor50,
    background = Gray900,
    onBackground = Gray50,
    surface = Gray900,
    onSurface = Gray50,
    surfaceVariant = Gray800,
    onSurfaceVariant = Gray300,
    surfaceTint = BrandColor500,
    inverseSurface = Gray50,
    inverseOnSurface = Gray900,
    error = AppColors.Error,
    onError = Gray50,
    errorContainer = AppColors.Error.copy(alpha = 0.2f),
    onErrorContainer = AppColors.Error,
    outline = Gray700,
    outlineVariant = Gray800,
    scrim = Gray900.copy(alpha = 0.5f),
)

@Composable
fun KEEVTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = darkColorScheme()
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme


    MaterialTheme(
        colorScheme = colorScheme,
        typography = KeevTypography,
        content = content,
    )
}