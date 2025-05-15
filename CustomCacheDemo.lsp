import java.util.HashMap;
import java.util.Map;

class CacheEntry<T> {

    T value;
    long expiryTime;

    public CacheEntry(T value, long ttl) {
        this.value = value;
        this.expiryTime = System.currentTimeMillis() + ttl;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

public class CustomCache<K, T> {

    private Map<K, CacheEntry<T>> cache = new HashMap<>();
    private long defaultTTL;

    public CustomCache(long defaultTTL) {
        this.defaultTTL = defaultTTL;
    }

    public void put(K key, T value) {
        CacheEntry<T> entry = new CacheEntry<>(value, defaultTTL);
        cache.put(key, entry);
    }

    public T get(K key) {
        CacheEntry<T> entry = cache.get(key);
        if (entry != null && !entry.isExpired()) {
            return entry.value;
        }
        cache.remove(key);
        return null;
    }

    public void remove(K key) {
         cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }

}


public class CustomCacheDemo {

    public static void main(String[] args) throws InterruptedException {
	
        CustomCache<String, String> myCache = new CustomCache<>(2000);

        myCache.put("apple", "red");
        System.out.println(myCache.get("apple")); // Output: red

        Thread.sleep(3000);
        System.out.println(myCache.get("apple")); // Output: null

        myCache.put("banana", "yellow");
        System.out.println(myCache.size()); // Output: 1
        myCache.clear();
        System.out.println(myCache.size()); // Output: 0
    }
	
}