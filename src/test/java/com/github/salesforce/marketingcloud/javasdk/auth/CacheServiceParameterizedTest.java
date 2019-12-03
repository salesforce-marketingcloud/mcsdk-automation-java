package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.SettableDateTimeProvider;
import com.github.salesforce.marketingcloud.javasdk.TestHelper;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CacheServiceParameterizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {29, false}, {30, false}, {31, true}
        });
    }

    private int windowInSeconds;
    private boolean isValidCacheValue;

    public CacheServiceParameterizedTest(int windowInSeconds, boolean expectedIsValidCacheValue)
    {
        this.windowInSeconds = windowInSeconds;
        this.isValidCacheValue = expectedIsValidCacheValue;
    }

    @Test
    public void get_WhenCalledForACachedValue_ReturnsBasedOnInvalidCacheWindow()
    {
        SettableDateTimeProvider dateTimeProvider = new SettableDateTimeProvider(
                LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0));
        CacheService cacheService = new CacheService(dateTimeProvider);

        String cacheKey = "cacheKey";
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        cacheService.addOrUpdate(cacheKey, tokenResponse);

        dateTimeProvider.setCurrentDate(
                dateTimeProvider
                        .getCurrentDate()
                        .plusSeconds(tokenResponse.getExpiresIn())
                        .minusSeconds(this.windowInSeconds)
        );

        boolean cachedValueNotNull = cacheService.get(cacheKey) != null;

        assertEquals(this.isValidCacheValue, cachedValueNotNull);
    }
}
