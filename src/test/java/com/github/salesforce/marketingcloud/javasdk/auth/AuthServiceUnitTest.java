package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.*;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class AuthServiceUnitTest {
    @Before
    public void setup() { CacheService.cache.clear(); }

    @After
    public void tearDown()
    {
        CacheService.cache.clear();
    }

    @Test
    public void tokenApiIsCalledOnEmptyCache() throws ApiException {
        ClientConfig clientConfig = TestHelper.createClientConfig();
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        ApiClient apiClientMock = createApiClientMock(tokenResponse);
        AuthService authService = new AuthService(clientConfig, apiClientMock, new CacheService(new DateTimeProvider()));

        authService.getTokenResponse();

        verify(apiClientMock, times(1)).execute(any(), eq(TokenResponse.class));
    }

    @Test
    public void tokenApiIsCalledOnExpiredCache() throws ApiException {
        ClientConfig clientConfig = TestHelper.createClientConfig();
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        ApiClient apiClientMock = createApiClientMock(tokenResponse);
        SettableDateTimeProvider settableDateTimeProvider = TestHelper.createSettableDateTimeProvider();
        AuthService authService = new AuthService(clientConfig, apiClientMock, new CacheService(settableDateTimeProvider));

        authService.getTokenResponse();
        settableDateTimeProvider.setCurrentDate(settableDateTimeProvider.getCurrentDate().plusMinutes(20));
        authService.getTokenResponse();

        verify(apiClientMock, times(2)).execute(any(), eq(TokenResponse.class));
    }

    @Test
    public void tokenApiIsCalledOnlyOnceForMultipleInstances() throws ApiException {
        ClientConfig clientConfig = TestHelper.createClientConfig();
        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        ApiClient apiClientMock = createApiClientMock(tokenResponse);

        AuthService authServiceInstance1 = new AuthService(clientConfig, apiClientMock, new CacheService(new DateTimeProvider()));
        authServiceInstance1.getTokenResponse();
        AuthService authServiceInstance2 = new AuthService(clientConfig, apiClientMock, new CacheService(new DateTimeProvider()));
        authServiceInstance2.getTokenResponse();

        verify(apiClientMock, times(1)).execute(any(), eq(TokenResponse.class));
    }

    @Test
    public void shouldCacheTokenResponseWithoutTrailingSlashesForUrls() throws ApiException {
        ClientConfig clientConfig = TestHelper.createClientConfig();

        TokenResponse tokenResponse = TestHelper.createTokenResponse();
        tokenResponse.setRestInstanceUrl(tokenResponse.getRestInstanceUrl() + "/");
        tokenResponse.setSoapInstanceUrl(tokenResponse.getSoapInstanceUrl() + "/");

        ApiClient apiClientMock = createApiClientMock(tokenResponse);
        SettableDateTimeProvider settableDateTimeProvider = TestHelper.createSettableDateTimeProvider();
        AuthService authService = new AuthService(clientConfig, apiClientMock, new CacheService(settableDateTimeProvider));

        TokenResponse returnedTokenResponse = authService.getTokenResponse();

        assertFalse(returnedTokenResponse.getRestInstanceUrl().endsWith("/"));
        assertFalse(returnedTokenResponse.getSoapInstanceUrl().endsWith("/"));

    }

    private ApiClient createApiClientMock(TokenResponse tokenResponse) throws ApiException {
        ApiClient apiClientMock = mock(ApiClient.class);
        when(apiClientMock.execute(any(), eq(TokenResponse.class))).thenReturn(new ApiResponse<>(
                200, new HashMap<>(), tokenResponse
        ));

        return apiClientMock;
    }
}
