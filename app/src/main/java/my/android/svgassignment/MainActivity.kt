package my.android.svgassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import my.android.svgassignment.navigation.AppNavigation
import my.android.svgassignment.ui.theme.SVGAssignmentTheme
import my.android.svgassignment.ui.viewmodel.DogViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: DogViewModel = viewModel()
            SVGAssignmentTheme {
               AppNavigation(viewModel)
            }
        }
    }
}