package my.android.svgassignment.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.android.svgassignment.ui.components.AppTopBar
import my.android.svgassignment.ui.viewmodel.DogViewModel

@Composable
fun RecentlyGeneratedScreen(viewModel: DogViewModel, onBackClick:()-> Unit) {

    val cachedDogs by viewModel.cachedDogs.collectAsState()

    Scaffold(topBar = { AppTopBar(title = "My recently generated dogs!", onBackClick = onBackClick) })
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}