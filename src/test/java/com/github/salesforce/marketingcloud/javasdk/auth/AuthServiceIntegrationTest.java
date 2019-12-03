package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.*;
import com.github.salesforce.marketingcloud.javasdk.exception.AuthenticationFailureException;
import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvVariableName;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvironmentConfigProvider;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import com.github.salesforce.marketingcloud.javasdk.validation.ModelValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AuthServiceIntegrationTest
{
    private AuthService authService;
    private ClientConfig clientConfig;
    private ApiClient apiClient;
    private CacheService cacheService;

    private String authBaseUrl;
    private String clientId;
    private String clientSecret;
    private String accountId;
    private String scope;

    @Before
    public void setup() throws EnvironmentVariableNotSetException {
        EnvironmentConfigProvider configProvider = new EnvironmentConfigProvider();
        this.authBaseUrl = configProvider.get(EnvVariableName.AUTH_BASE_URL);
        this.clientId = configProvider.get(EnvVariableName.CLIENT_ID);
        this.clientSecret = configProvider.get(EnvVariableName.CLIENT_SECRET);
        this.accountId = configProvider.get(EnvVariableName.ACCOUNT_ID);
        this.scope = configProvider.get(EnvVariableName.SCOPE, false);

        this.clientConfig = new ClientConfig(
                this.authBaseUrl, this.clientId, this.clientSecret, this.accountId, this.scope);
        this.apiClient = new ApiClient(new RuntimeInformationProvider(), new ModelValidator());
        this.cacheService = new CacheService(new DateTimeProvider());
    }

    @After()
    public void tearDown()
    {
        CacheService.cache.clear();
    }

    @Test
    public void shouldReturnTokenResponseOnValidCredentials() throws ApiException {
        this.authService = new AuthService(clientConfig, apiClient, cacheService);

        TokenResponse tokenResponse = this.authService.getTokenResponse();

        assertNotNull(tokenResponse.getAccessToken());
        assertNotNull(tokenResponse.getTokenType());
        assertNotNull(tokenResponse.getRestInstanceUrl());
        assertNotNull(tokenResponse.getSoapInstanceUrl());
        assertNotNull(tokenResponse.getScope());
        assertTrue(tokenResponse.getExpiresIn() > 0);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void shouldThrowAuthenticationFailureExceptionOnInvalidClientId() throws ApiException {
        exceptionRule.expect(AuthenticationFailureException.class);

        this.clientConfig = new ClientConfig(
                this.authBaseUrl, "invalid", this.clientSecret, this.accountId, this.scope);
        this.authService = new AuthService(this.clientConfig, this.apiClient, this.cacheService);

        this.authService.getTokenResponse();
    }

    @Test
    public void shouldThrowAuthenticationFailureExceptionOnInvalidClientSecret() throws ApiException {
        exceptionRule.expect(AuthenticationFailureException.class);

        this.clientConfig = new ClientConfig(
                this.authBaseUrl, this.clientId, "invalid", this.accountId, this.scope);
        this.authService = new AuthService(this.clientConfig, this.apiClient, this.cacheService);

        this.authService.getTokenResponse();
    }

    @Test
    public void shouldReturnTheSameAccessTokenResponseInstanceWhenCalledMultipleTimes() throws ApiException {
        this.authService = new AuthService(clientConfig, apiClient, cacheService);

        TokenResponse tokenResponse1 = this.authService.getTokenResponse();
        TokenResponse tokenResponse2 = this.authService.getTokenResponse();

        assertSame(tokenResponse1, tokenResponse2);
    }

    @Test
    public void shouldCallOnlyOneTimeTheApiClientExecuteMethodWhenMultipleInstancesAreUsed() throws ApiException {
        ApiClient apiClientSpy = spy(new ApiClient(new RuntimeInformationProvider(), new ModelValidator()));

        AuthService authServiceInstance1 = new AuthService(clientConfig, apiClientSpy, cacheService);
        AuthService authServiceInstance2 = new AuthService(clientConfig, apiClientSpy, cacheService);

        authServiceInstance1.getTokenResponse();
        authServiceInstance2.getTokenResponse();

        verify(apiClientSpy, times(1)).execute(any(), eq(TokenResponse.class));
    }
}
