package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.DateTimeProvider;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class CacheService {
    private final DateTimeProvider dateTimeProvider;
    static ConcurrentHashMap<String, Pair<TokenResponse, LocalDateTime>> cache;
    private final int invalidCacheWindowInSeconds = 30;

    static {
        cache = new ConcurrentHashMap<>();
    }

    public CacheService(DateTimeProvider dateTimeProvider)
    {
        this.dateTimeProvider = dateTimeProvider;
    }

    public TokenResponse get(String key) {
        if(cache.containsKey(key)){
            Pair<TokenResponse, LocalDateTime> cachedPair = cache.get(key);
            if(cachedPair.getValue().isAfter(dateTimeProvider.getCurrentDate()))
            {
                return cachedPair.getKey();
            }
        }
        return null;
    }

    public void addOrUpdate(String key, TokenResponse value) {
        LocalDateTime expirationDate =
                this.dateTimeProvider.getCurrentDate().plusSeconds(value.getExpiresIn() - invalidCacheWindowInSeconds);
        cache.put(key, new ImmutablePair<>(value, expirationDate));
    }
}
