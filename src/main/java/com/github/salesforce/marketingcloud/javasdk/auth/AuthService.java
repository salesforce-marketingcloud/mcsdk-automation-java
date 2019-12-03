package com.github.salesforce.marketingcloud.javasdk.auth;

import com.github.salesforce.marketingcloud.javasdk.ApiClient;
import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.ApiResponse;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import com.google.gson.JsonObject;
import com.squareup.okhttp.*;

import java.util.Collections;

public class AuthService {
    private final ClientConfig clientConfig;
    private final ApiClient apiClient;
    private final CacheService cacheService;

    public AuthService(ClientConfig clientConfig, ApiClient apiClient, CacheService cacheService) {
        this.clientConfig = clientConfig;
        this.apiClient = apiClient;
        this.cacheService = cacheService;
    }

    public TokenResponse getTokenResponse() throws ApiException {
        String cacheKey = this.getCacheKey();
        TokenResponse cachedTokenResponse = this.cacheService.get(cacheKey);

        if(cachedTokenResponse == null) {
            String authBasePath = removeUrlTrailingSlash(this.clientConfig.getAuthBasePath());

            this.apiClient.setBasePath(authBasePath);
            Call tokenCall = buildTokenCall();

            ApiResponse<TokenResponse> response = this.apiClient.execute(tokenCall, TokenResponse.class);
            TokenResponse tokenResponse = response.getData();

            this.sanitizeUrls(tokenResponse);
            this.cacheService.addOrUpdate(cacheKey, tokenResponse);

            return tokenResponse;
        }
        else
        {
            return cachedTokenResponse;
        }
    }

    private Call buildTokenCall() throws ApiException {
        return this.apiClient.buildCall(
            "/v2/token",
            "POST",
            Collections.emptyList(),
            Collections.emptyList(),
            getTokenRequestPayload(),
            Collections.emptyMap(),
            Collections.emptyMap(),
            new String[0],
            null
        );
    }

    private JsonObject getTokenRequestPayload() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("client_id", this.clientConfig.getClientId());
        jsonObject.addProperty("client_secret", this.clientConfig.getClientSecret());
        jsonObject.addProperty("grant_type", "client_credentials");
        jsonObject.addProperty("account_id", this.clientConfig.getAccountId());
        String scope = this.clientConfig.getScope();
        if (scope != null && scope.length() > 0) {
            jsonObject.addProperty("scope", scope);
        }

        return jsonObject;
    }

    private String getCacheKey()
    {
        return this.clientConfig.getClientId() + "-" + this.clientConfig.getAccountId();
    }

    private String removeUrlTrailingSlash(String url)
    {
        if(url.endsWith("/")) {
            return url.substring(0, url.length() - 1);
        }
        return url;
    }

    private void sanitizeUrls(TokenResponse tokenResponse)
    {
        tokenResponse.setRestInstanceUrl(removeUrlTrailingSlash(tokenResponse.getRestInstanceUrl()));
        tokenResponse.setSoapInstanceUrl(removeUrlTrailingSlash(tokenResponse.getSoapInstanceUrl()));
    }
}
