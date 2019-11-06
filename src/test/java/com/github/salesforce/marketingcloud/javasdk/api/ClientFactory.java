package com.github.salesforce.marketingcloud.javasdk.api;

import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvVariableName;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvironmentConfigProvider;

public class ClientFactory {
    static EnvironmentConfigProvider configProvider = new EnvironmentConfigProvider();

    public static Client createClient() throws EnvironmentVariableNotSetException {
        return new Client(
          configProvider.get(EnvVariableName.AUTH_BASE_URL),
          configProvider.get(EnvVariableName.CLIENT_ID),
          configProvider.get(EnvVariableName.CLIENT_SECRET),
          configProvider.get(EnvVariableName.ACCOUNT_ID),
          configProvider.get(EnvVariableName.SCOPE, false)
        );
    }
}
