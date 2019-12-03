package com.github.salesforce.marketingcloud.javasdk.api;

import com.github.salesforce.marketingcloud.javasdk.ApiClient;
import com.github.salesforce.marketingcloud.javasdk.DateTimeProvider;
import com.github.salesforce.marketingcloud.javasdk.OAuth2ApiClient;
import com.github.salesforce.marketingcloud.javasdk.RuntimeInformationProvider;
import com.github.salesforce.marketingcloud.javasdk.auth.AuthService;
import com.github.salesforce.marketingcloud.javasdk.auth.CacheService;
import com.github.salesforce.marketingcloud.javasdk.auth.ClientConfig;
import com.github.salesforce.marketingcloud.javasdk.validation.ModelValidator;

public abstract class BaseApi {
    protected ApiClient apiClient;
    protected AuthService authService;

    protected BaseApi(String authBaseUrl, String clientId, String clientSecret, String accountId, String scope) {
        ClientConfig clientConfig = new ClientConfig(authBaseUrl, clientId, clientSecret, accountId, scope);
        DateTimeProvider dateTimeProvider = new DateTimeProvider();
        CacheService cacheService = new CacheService(dateTimeProvider);
        RuntimeInformationProvider runtimeInformationProvider = new RuntimeInformationProvider();
        ModelValidator modelValidator = new ModelValidator();
        ApiClient apiClient = new ApiClient(runtimeInformationProvider,  modelValidator);

        this.authService = new AuthService(clientConfig, apiClient, cacheService);
        this.apiClient = new OAuth2ApiClient(runtimeInformationProvider, authService, modelValidator);
    }
}
