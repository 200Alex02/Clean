package com.example.cleantest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cleantest.ui.theme.CleanTestTheme
import com.feature.presentation.ui.ListPlayersScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CleanTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanTestTheme {
                ListPlayersScreen()
            }
        }
    }
}
