package com.github.salesforce.marketingcloud.javasdk;

import com.github.salesforce.marketingcloud.javasdk.auth.AuthService;
import com.github.salesforce.marketingcloud.javasdk.model.TokenResponse;
import com.github.salesforce.marketingcloud.javasdk.validation.ModelValidator;
import com.squareup.okhttp.Request;

import java.util.List;
import java.util.Map;

public class OAuth2ApiClient extends ApiClient {
    private final AuthService authService;

    public OAuth2ApiClient(RuntimeInformationProvider runtimeInformationProvider,
                           AuthService authService,
                           ModelValidator modelValidator)
    {
        super(runtimeInformationProvider, modelValidator);
        this.authService = authService;
    }

    @Override
    public Request buildRequest(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        TokenResponse response = this.authService.getTokenResponse();
        this.setBasePath(response.getRestInstanceUrl());
        this.setAccessToken(response.getAccessToken());

        return super.buildRequest(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, progressRequestListener);
    }
}
