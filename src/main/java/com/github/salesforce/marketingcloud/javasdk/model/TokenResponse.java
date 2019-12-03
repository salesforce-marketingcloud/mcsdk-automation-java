package com.github.salesforce.marketingcloud.javasdk.model;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private Integer expiresIn;

    @SerializedName("rest_instance_url")
    private String restInstanceUrl;

    @SerializedName("soap_instance_url")
    private String soapInstanceUrl;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("scope")
    private String scope;

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRestInstanceUrl() {
        return restInstanceUrl;
    }

    public void setRestInstanceUrl(String restInstanceUrl) {
        this.restInstanceUrl = restInstanceUrl;
    }

    public String getSoapInstanceUrl() {
        return soapInstanceUrl;
    }

    public void setSoapInstanceUrl(String soapInstanceUrl) {
        this.soapInstanceUrl = soapInstanceUrl;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
