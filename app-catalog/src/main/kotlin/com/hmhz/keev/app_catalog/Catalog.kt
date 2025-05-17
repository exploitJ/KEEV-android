package com.hmhz.keev.app_catalog

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.hmhz.keev.core.designsystem.component.RatingBarDemo
import com.hmhz.keev.core.designsystem.theme.KEEVTheme

@Composable
fun KeevCatalog(padding: PaddingValues) {
    KEEVTheme {
        Surface(modifier = Modifier.padding(padding)) {
            RatingBarDemo()
        }

    }
}