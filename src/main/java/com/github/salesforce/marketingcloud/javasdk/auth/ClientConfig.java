package com.github.salesforce.marketingcloud.javasdk.auth;

public class ClientConfig {
    private final String authBasePath;
    private final String clientId;
    private final String clientSecret;
    private final String accountId;
    private final String scope;

    public ClientConfig(String authBasePath, String clientId, String clientSecret, String accountId, String scope) {
        // TODO - validate required parameters
        this.authBasePath = authBasePath;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accountId = accountId;
        this.scope = scope;
    }

    public String getAuthBasePath() {
        return authBasePath;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getScope() {
        return scope;
    }
}
