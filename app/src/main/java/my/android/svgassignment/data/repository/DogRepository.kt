package my.android.svgassignment.data.repository

import android.content.SharedPreferences
import my.android.svgassignment.data.remote.DogApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRepository @Inject constructor(
    private val api: DogApiService,
    private val sharedPrefs: SharedPreferences
) {

}
