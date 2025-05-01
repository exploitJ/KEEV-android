package com.hmhz.keev.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*

private val LightColorScheme = lightColorScheme(
    primary = BrandColor500,
    onPrimary = Gray50,
    primaryContainer = BrandColor50,
    onPrimaryContainer = BrandColor500,
    secondary = BrandColor500a50,
    onSecondary = Gray50,
    secondaryContainer = BrandColor50,
    onSecondaryContainer = BrandColor500,
    tertiary = BrandColor500a20,
    onTertiary = Gray50,
    tertiaryContainer = BrandColor50,
    onTertiaryContainer = BrandColor500,
    background = Gray50,
    onBackground = Gray900,
    surface = Gray50,
    onSurface = Gray900,
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray700,
    surfaceTint = BrandColor500,
    inverseSurface = Gray900,
    inverseOnSurface = Gray50,
    error = Error,
    onError = Gray50,
    errorContainer = Error.copy(alpha = 0.1f),
    onErrorContainer = Error,
    outline = Gray300,
    outlineVariant = Gray100,
    scrim = Gray900.copy(alpha = 0.3f),
)


@Composable
fun KEEVTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = KeevTypography,
        content = content,
    )
}