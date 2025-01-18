package my.android.svgassignment.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import my.android.svgassignment.ui.components.AppButton
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (cachedDogs.isNotEmpty()) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(cachedDogs) { dog ->
                        AsyncImage(
                            model = dog.url,
                            contentDescription = "Cached Dog",
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .height(440.dp)
                                .width(360.dp)
                        )
                    }
                }
            } else {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(440.dp)
                )
            }
            Spacer(Modifier.height(16.dp))

            AppButton(
                title = "Clear Dogs!",
                onButtonClick = { viewModel.clearDogs() }
            )
        }
    }
}