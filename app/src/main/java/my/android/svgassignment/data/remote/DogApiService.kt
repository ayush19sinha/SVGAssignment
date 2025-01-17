package my.android.svgassignment.data.remote

import my.android.svgassignment.data.model.ApiResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getDogImages(): ApiResponse
}