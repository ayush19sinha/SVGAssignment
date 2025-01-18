package my.android.svgassignment.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import my.android.svgassignment.ui.theme.PrimaryButtonColor

@Composable
fun AppButton(title: String, onButtonClick:()-> Unit, enabled: Boolean = true){
    Button(
        onClick = onButtonClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryButtonColor
        )
    ) {
        Text(title)
    }
}