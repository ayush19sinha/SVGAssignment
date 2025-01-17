package my.android.svgassignment.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import my.android.svgassignment.ui.theme.PrimaryButtonColor

@Composable
fun HomeScreen(
    onNavigateToGenerate: () -> Unit,
    onNavigateToRecentlyGenerated: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text("Random Dog Generator!", fontSize = 20.sp)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = onNavigateToGenerate,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryButtonColor
                )
            ) {
                Text("Generate Dogs!")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onNavigateToRecentlyGenerated,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryButtonColor
                )
            ) {
                Text("My Recently Generated Dogs!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(onNavigateToGenerate = {}, onNavigateToRecentlyGenerated = {})
}