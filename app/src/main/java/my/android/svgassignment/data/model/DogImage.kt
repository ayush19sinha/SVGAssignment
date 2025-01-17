package my.android.svgassignment.data.model


data class DogImage(
    val url: String,
    val timestamp: Long = System.currentTimeMillis()
)