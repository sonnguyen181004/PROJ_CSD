package browser;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static final Map<String, WebPage> cache = new HashMap<>();

    public static void addCache(WebPage page) {
        if (page != null) {
            cache.put(page.getUrl(), page);
        }
    }

    public static WebPage getCachePage(String url) {
        return cache.get(url);
    }

    public static boolean contains(String url) {
        return cache.containsKey(url);
    }

    public static void clearCache() {
        cache.clear();
    }
    
    public static Map<String, WebPage> getCache() {
        return cache;
    }
}
