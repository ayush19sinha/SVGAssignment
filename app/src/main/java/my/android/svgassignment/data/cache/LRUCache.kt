package my.android.svgassignment.data.cache

class LRUCache<K, V>(private val maxSize: Int) {
    private val cache = LinkedHashMap<K, V>(maxSize, 0.75f, true)

    @Synchronized
    fun put(key: K, value: V) {
        cache[key] = value
        if (cache.size > maxSize) {
            cache.remove(cache.keys.first())
        }
    }

    @Synchronized
    fun get(key: K): V? = cache[key]

    @Synchronized
    fun clear() = cache.clear()

    @Synchronized
    fun values(): List<V> = cache.values.toList()
}