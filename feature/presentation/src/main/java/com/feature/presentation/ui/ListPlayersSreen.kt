package com.feature.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.feature.presentation.viewModels.ListPlayersViewModel

@Composable
fun ListPlayersScreen(
    viewModel: ListPlayersViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    var shownPlayersCount by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        viewModel.getAnalytics(shownPlayersCount)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {
            items(
                state.value.players,
                key = { player -> player.age }
            ) { player ->
                PlayerItem(player)
                shownPlayersCount++
            }
        }
        if (state.value.errorMessage.isNotEmpty()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = state.value.errorMessage,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}