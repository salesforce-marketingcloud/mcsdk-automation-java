package com.github.salesforce.marketingcloud.javasdk;

import com.github.salesforce.marketingcloud.javasdk.auth.ClientConfig;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;

import java.time.LocalDateTime;
import java.time.Month;

public class TestHelper {

    public static TokenResponse createTokenResponse()
    {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken("access_token");
        tokenResponse.setTokenType("token_type");
        tokenResponse.setExpiresIn(1000);
        tokenResponse.setRestInstanceUrl("https://rest.com");
        tokenResponse.setSoapInstanceUrl("https://soap.com");
        tokenResponse.setScope("scope");

        return tokenResponse;
    }

    public static SettableDateTimeProvider createSettableDateTimeProvider()
    {
        return new SettableDateTimeProvider(LocalDateTime.of(
                2000, Month.JANUARY, 1, 0, 0)
        );
    }

    public static ClientConfig createClientConfig()
    {
        return new ClientConfig(
                "https://auth.com",
                "clientId",
                "clientSecret",
                "123456",
                null
        );
    }
}
