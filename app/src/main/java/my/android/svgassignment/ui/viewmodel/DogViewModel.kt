package my.android.svgassignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import my.android.svgassignment.data.model.DogImage
import my.android.svgassignment.data.repository.DogRepository
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    private val _currentDog = MutableStateFlow<DogImage?>(null)
    val currentDog: StateFlow<DogImage?> = _currentDog.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _cachedDogs = MutableStateFlow<List<DogImage>>(emptyList())
    val cachedDogs: StateFlow<List<DogImage>> = _cachedDogs.asStateFlow()

    init {
        updateCachedDogs()
    }

    fun generateDog() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.generateDog()
                .onSuccess { dog ->
                    _currentDog.value = dog
                    updateCachedDogs()
                }
            _isLoading.value = false
        }
    }

    fun clearDogs() {
        repository.clearCache()
        _currentDog.value = null
        updateCachedDogs()
    }

    private fun updateCachedDogs() {
        _cachedDogs.value = repository.getCachedDogs()
    }
}