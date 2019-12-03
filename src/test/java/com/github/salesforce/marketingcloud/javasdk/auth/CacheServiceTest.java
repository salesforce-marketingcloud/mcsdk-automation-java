package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.SettableDateTimeProvider;
import com.github.salesforce.marketingcloud.javasdk.TestHelper;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CacheServiceTest {

    private String cacheKey = "cacheKey";

    @Before
    public void setup() { CacheService.cache.clear(); }

    @After
    public void tearDown() { CacheService.cache.clear(); }

    @Test
    public void get_WhenKeyNotPresent_ReturnsNull() {
        CacheService cacheService = new CacheService(TestHelper.createSettableDateTimeProvider());
        assertNull(cacheService.get(cacheKey));
    }

    @Test
    public void get_WhenCacheIsNotExpired_ReturnsCachedValue() {
        CacheService cacheService = new CacheService(TestHelper.createSettableDateTimeProvider());
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        cacheService.addOrUpdate(cacheKey, tokenResponse);

        TokenResponse cachedTokenResponse = cacheService.get(cacheKey);

        assertNotNull(cachedTokenResponse);
        assertEquals(tokenResponse.getAccessToken(), cachedTokenResponse.getAccessToken());
        assertEquals(tokenResponse.getTokenType(), cachedTokenResponse.getTokenType());
        assertEquals(tokenResponse.getExpiresIn(), cachedTokenResponse.getExpiresIn());
        assertEquals(tokenResponse.getRestInstanceUrl(), cachedTokenResponse.getRestInstanceUrl());
        assertEquals(tokenResponse.getSoapInstanceUrl(), cachedTokenResponse.getSoapInstanceUrl());
        assertEquals(tokenResponse.getScope(), cachedTokenResponse.getScope());
    }

    @Test
    public void get_WhenCacheIsExpired_ReturnsNull() {
        SettableDateTimeProvider dateTimeProvider = TestHelper.createSettableDateTimeProvider();
        CacheService cacheService = new CacheService(dateTimeProvider);
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        cacheService.addOrUpdate(cacheKey, tokenResponse);

        LocalDateTime currentDateTime = dateTimeProvider.getCurrentDate();
        LocalDateTime expiredCacheDateTime = currentDateTime.plusMinutes(20);
        dateTimeProvider.setCurrentDate(expiredCacheDateTime);

        TokenResponse cachedTokenResponse = cacheService.get(cacheKey);

        assertNull(cachedTokenResponse);
    }

    @Test
    public void addOrUpdate_WhenCalledTwoTimesForTheSameKey_OverwritesCachedValue() {
        SettableDateTimeProvider dateTimeProvider = TestHelper.createSettableDateTimeProvider();
        CacheService cacheService = new CacheService(dateTimeProvider);
        TokenResponse tokenResponse = TestHelper.createTokenResponse();

        cacheService.addOrUpdate(cacheKey, tokenResponse);

        TokenResponse newTokenResponse = TestHelper.createTokenResponse();
        cacheService.addOrUpdate(cacheKey, newTokenResponse);

        TokenResponse cachedTokenResponse = cacheService.get(cacheKey);

        assertEquals(cachedTokenResponse, newTokenResponse);
    }
}