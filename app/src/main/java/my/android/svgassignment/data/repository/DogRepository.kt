package my.android.svgassignment.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import my.android.svgassignment.data.cache.LRUCache
import my.android.svgassignment.data.model.DogImage
import my.android.svgassignment.data.remote.DogApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRepository @Inject constructor(
    private val api: DogApiService,
    private val sharedPrefs: SharedPreferences
) {
    private val cache = LRUCache<String, DogImage>(20)

    init {
        loadCacheFromPrefs()
    }

    suspend fun generateDog(): Result<DogImage> = try {
        val response = api.getDogImages()
        if (response.status == "success") {
            val dogImage = DogImage(response.message)
            cache.put(dogImage.url, dogImage)
            saveCacheToPrefs()
            Result.success(dogImage)
        } else {
            Result.failure(Exception("API Error"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun getCachedDogs(): List<DogImage> = cache.values()

    fun clearCache() {
        cache.clear()
        sharedPrefs.edit().clear().apply()
    }

    private fun saveCacheToPrefs() {
        val json = Gson().toJson(getCachedDogs())
        sharedPrefs.edit().putString("cache", json).apply()
    }

    private fun loadCacheFromPrefs() {
        val json = sharedPrefs.getString("cache", null) ?: return
        val type = object : TypeToken<List<DogImage>>() {}.type
        val dogs = Gson().fromJson<List<DogImage>>(json, type)
        dogs.forEach { cache.put(it.url, it) }
    }
}
